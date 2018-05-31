#!/bin/bash

if [ $1 = "clean" ]; then
	docker stop $(docker ps -aq) 
	docker rm $(docker ps -aq)
	docker rmi $(docker images -q)
fi

cd new-api-gateway
mvn clean package
docker build -t new-api-gateway .

cd ..

cd new-discovery-service
mvn clean package
docker build -t new-discovery-server .

cd ..

cd new-meta-server
mvn clean package
docker build -t new-meta-server .

cd ..

cd new-io-server
mvn clean package
docker build -t new-io-server .

cd ..

docker-compose up