/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 2:23 AM
*/

package org.rishabh.t.producer;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.rishabh.t.config.KafkaConfig;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Producer <T> {

    private Gson gson = new Gson();
    private org.apache.kafka.clients.producer.Producer<String, T> kafkaProducer = null;
    private KafkaConfig kafkaConfig = null;

    @Autowired
    public void InitializeKafkaProducer (KafkaConfig kafkaConfig) {
        this.kafkaConfig = kafkaConfig;
        this.kafkaProducer = new KafkaProducer<String, T>(this.kafkaConfig.getKafkaConfig());
    }

    public org.apache.kafka.clients.producer.Producer<String, T> getKafkaProducer() {
        return kafkaProducer;
    }

    public void setKafkaProducer(org.apache.kafka.clients.producer.Producer<String, T> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }


    public abstract void produce () throws InterruptedException;

}
