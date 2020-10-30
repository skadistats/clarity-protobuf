#!/bin/sh
/opt/protobuf2/bin/protoc --proto_path=/opt/protobuf2/include --proto_path=../common --proto_path=. --java_out=../../java cstrike*.proto
/opt/protobuf2/bin/protoc --proto_path=/opt/protobuf2/include --proto_path=. --java_out=../../java csgo*.proto
