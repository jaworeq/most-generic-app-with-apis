#!/bin/sh
docker build -t test-run --target=test .
docker run -v /var/run/docker.sock://var/run/docker.sock -it test-run