#!/bin/sh
/opt/protobuf2/bin/protoc --proto_path=/usr/include/protobuf2 --proto_path=../common --proto_path=. --java_out=../../java cstrike*.proto
/opt/protobuf2/bin/protoc --proto_path=/usr/include/protobuf2 --proto_path=. --java_out=../../java csgo*.proto
