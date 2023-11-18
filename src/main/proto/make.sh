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
