#!/bin/sh
/opt/protobuf2/bin/protoc --proto_path=/opt/protobuf2/include --proto_path=. --java_out=../../java *.proto

