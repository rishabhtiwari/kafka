/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 7:40 PM
*/

package org.rishabh.t.consumer;

import com.google.gson.Gson;
import org.rishabh.t.config.KafkaConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Consumer <T> {

    private KafkaConfig kafkaConfig;
    private KafkaConsumer<String, T> kafkaConsumer;
    private Gson gson = new Gson();

    @Autowired
    public void InitializeKafkaConsumer(KafkaConfig kafkaConfig) {
        this.kafkaConfig = kafkaConfig;
        this.kafkaConsumer = new KafkaConsumer<String, T>(this.kafkaConfig.getKafkaConfig());
    }

    public KafkaConsumer<String, T> getKafkaConsumer() {
        return kafkaConsumer;
    }

    public void setKafkaConsumer(KafkaConsumer<String, T> kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }


    public abstract void consume();
}
