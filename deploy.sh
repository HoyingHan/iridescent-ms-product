#!/usr/bin/env bash
git pull
mvn clean package -U -Dmaven.test.skip=true
mvn deploy -Dmaven.test.skip=true