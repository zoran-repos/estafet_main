- Starting kafka environment - Win ENV

(Starting zookeeper)
1. zookeeper-server-start.bat ..\..\config\zookeeper.properties

(Starting broker)
2. kafka-server-start.bat ..\..\config\server.properties

(Creating topic for payments)
3. kafka-topics.bat --bootstrap-server localhost:9092 --create --topic payments --partitions 1 --replication-factor 1

(Checking list of current topics)
4. kafka-topics.bat --bootstrap-server localhost:9092 --list

You can use local instalation of DB or docker with command: docker pull postgres)
Table that is in use SQL script is:
CREATE TABLE public.payments
(
    paymentid character varying(100) COLLATE pg_catalog."default" NOT NULL,
    "timestamp" character varying(100) COLLATE pg_catalog."default" NOT NULL,
    amount numeric,
    currency character varying(10) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    sendername character varying(100) COLLATE pg_catalog."default" NOT NULL,
    senderiban character varying(100) COLLATE pg_catalog."default" NOT NULL,
    receivername character varying(100) COLLATE pg_catalog."default" NOT NULL,
    receiveriban character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT payments_pkey PRIMARY KEY (paymentid)
)
File payments.json is stored 1000 payments (for testing purposes) - location ..\src\main\resources\
(Before starting application run this command for sending messages into topic 'payments' and storing into PostgeSQL)

5. kafka-console-producer.bat --broker-list localhost:9092 --topic payments < payments.json

(Checking messages without starting application)
6. kafka-console-consumer.bat --bootstrap-server 127.0.0.1:9092 --topic payments  --consumer-property group.id=consumer_for_db


