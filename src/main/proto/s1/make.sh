#!/bin/sh
protobuf2-protoc --proto_path=../common --proto_path=. --java_out=../../java *.proto