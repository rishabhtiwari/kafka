/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 7:50 PM
*/

package org.rishabh.t.consumer;

import org.rishabh.t.models.Country;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.context.annotation.Configuration;
import org.rishabh.t.utility.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Configuration
public class CountryConsumer extends Consumer{

    @Override
    public void consume() {
        try{
            Collection<String> topics = new ArrayList<>(Arrays.asList(Constants.Topics.COUNTRY_TOPIC));
            this.getKafkaConsumer().subscribe(topics);
            while(true) {
                ConsumerRecords<String, Country> countryConsumerRecords = (ConsumerRecords<String, Country>) this.getKafkaConsumer().poll(100);
                for(ConsumerRecord<String, Country> consumerRecord : countryConsumerRecords) {
                    System.out.println("key: " + consumerRecord.key());
                    System.out.println("Value: " + consumerRecord.value());
                }
                this.getKafkaConsumer().commitSync();
            }
        }finally {
            this.getKafkaConsumer().close();
        }
    }
}
