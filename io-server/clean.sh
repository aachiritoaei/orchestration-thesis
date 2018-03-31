#!/bin/bash

docker stop ioserver_web_server_1
docker stop cassandra

docker rm ioserver_web_server_1
docker rm cassandra

docker rmi ioserver_web_server:latest
#docker rmi java:8
#docker rmi cassandra:latest