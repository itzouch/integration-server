command

后台启动zk  bin目录下执行
sh ./zkServer.sh start

nohup ./zkServer.sh ../config/zookeeper.properties 1>/dev/null 2>&1 &

后台启动kafka bin目录下执行
nohup ./kafka-server-start.sh ../config/server.properties 1>/dev/null 2>&1 &

启动kafka生产者和消费者
./kafka-console-producer.sh --broker-list 127.27.244.104:9092 --topic zouqi
./kafka-console-consumer.sh --bootstrap-server 127.27.244.104:9092 --topic zouqi

创建topic
    bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 3 --partitions 3 --topic zouqi

查看topic
./kafka-topics.sh --zookeeper=localhost:2181  --list


