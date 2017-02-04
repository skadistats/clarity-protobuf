#!/bin/sh
protobuf2-protoc --proto_path=/usr/include/protobuf2 --proto_path=../common --proto_path=. --java_out=../../java *.proto