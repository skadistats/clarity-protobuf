#!/bin/sh
protoc --proto_path=../common --proto_path=. --java_out=../../java *.proto