#!/usr/bin/env bash
#mvn -Pnative -DskipTests  spring-aot:generate
mvn -Pnative -DskipTests clean package && ./target/swagger