#!/bin/sh

query()
{
  local __result=$1
  eval $__result=`cat build.json | jq "$2"`
}

query LEN ".|length"
for e in `seq 0 $(($LEN-1))`
do

  query INCLEN ".[$e].include|length"

  CMD="/opt/protobuf2/bin/protoc --java_out=../java --proto_path=/opt/protobuf2/include"
  for i in `seq 0 $(($INCLEN-1))`
  do
    query INCP ".[$e].include[$i]"
    CMD="$CMD --proto_path=$INCP"
  done

  query P ".[$e].path"
  CMD="$CMD --proto_path=$P"

  query B ".[$e].build"
  CMD="$CMD $P/$B"

  echo "executing $CMD"
  eval $CMD

done

# protoc hardcodes the runtime package in its output; rewrite it to the
# relocated runtime package. Idempotent: no matches remain after the first pass.
find ../java/skadistats -name '*.java' -exec \
  sed -i 's/com\.google\.protobuf/skadistats.clarity.protobuf/g' {} +

# Assert over the whole output tree, not just skadistats/: a google/protobuf
# proto compiled as a build target lands in ../java/com/google/protobuf/ and
# cannot be fixed by the rewrite above (it also needs to move). Fail loudly.
if grep -rq 'com\.google\.protobuf' ../java; then
  echo "make.sh: com.google.protobuf survived — a google/protobuf proto was compiled as a build target and must be vendored into the runtime, not just rewritten" >&2
  exit 1
fi
