#!/bin/sh
docker build -f tests.Dockerfile -t test-run .
docker run -v /var/run/docker.sock://var/run/docker.sock -it test-run