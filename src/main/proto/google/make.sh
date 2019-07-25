#!/bin/sh
protoc --proto_path=. --java_out=../../java *.proto
