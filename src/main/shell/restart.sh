#!/bin/sh

BASE_DIR=$(cd "$(dirname "$0")"; pwd)/
cd $BASE_DIR

sh daemon.sh restart