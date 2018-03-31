# io-server

# run cass with this command
docker run -p 9042:9042 -p 9160:9160 --rm --name cassandradb-01 -d cassandra:latest

docker run --name web_server --link cassandradb-01:cassandra -d ioserver_web_server   

mvn package
docker build -t ioserver_web_server .


docker stop $(docker ps -aq) 
docker rm $(docker ps -aq)
docker rmi $(docker images -q)

# start app
# test with postman

