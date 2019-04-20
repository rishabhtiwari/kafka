/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 11:14 AM
*/

package org.rishabh.t.config;


import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.rishabh.t.utility.CustomPartitioner;
import org.rishabh.t.utility.CustomSerializer;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class KafkaConfig {

    private static Properties kafkaProps;
    static {
        kafkaProps = new Properties();
        kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); //bootstrap Server;
        kafkaProps.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class.getName()); //Partition Name
        kafkaProps.put(ProducerConfig.BATCH_SIZE_CONFIG, 1024); //batch Size;
        kafkaProps.put(ProducerConfig.LINGER_MS_CONFIG, 10); //linger time (time to wait to make request to broker)
        kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); //key serializer
        kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CustomSerializer.class.getName()); //value serializer
        kafkaProps.put(ProducerConfig.ACKS_CONFIG, "all"); //ack
        kafkaProps.put(ProducerConfig.RETRIES_CONFIG, 3); //retries
        kafkaProps.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 12*1024);
    }

    public Properties getKafkaConfig(){
        return kafkaProps;
    }
}
