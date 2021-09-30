#!/usr/bin/env bash
CRED=bk
docker run -p 5432:5432 -e POSTGRES_USER=$CRED -e PGUSER=$CRED -e POSTGRES_PASSWORD=$CRED postgres:latest
