#!/usr/bin/env bash
mvn -Pnative -DskipTests clean package && ./target/spring-plugin