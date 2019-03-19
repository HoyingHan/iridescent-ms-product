#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -U

docker build -t iridescent/product .

docker push ccr.ccs.tencentyun.com/iridescent/product:0.0.1


