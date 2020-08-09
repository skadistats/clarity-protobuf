#!/bin/sh
/opt/protobuf2/bin/protoc --proto_path=. --java_out=../../java *.proto
