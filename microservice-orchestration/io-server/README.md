# I/O Server

# run cassandra container 
docker run -p 9042:9042 -p 9160:9160 --rm --name cassandradb-01 -d cassandra:latest

# run kafka
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic kafka-io
bin/kafka-topics.sh --list --zookeeper localhost:2181
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic kafka-io
 



