command

后台启动
nohup ./zkServer.sh ../config/zookeeper.properties &
nohup ./kafka-server-start.sh ../config/server.properties &

启动
 bin/kafka-server-start.sh config/server.properties
创建topic
    bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 3 --partitions 3 --topic zouqi
查看topic
./kafka-topics.sh --zookeeper=localhost:2181  --list