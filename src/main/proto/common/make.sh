#!/bin/sh
protoc --proto_path=/usr/include/protobuf2 --proto_path=. --java_out=../../java *.proto

