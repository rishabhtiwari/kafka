/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 9:37 PM
*/

package org.rishabh.t.consumer;

import org.rishabh.t.models.Company;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.context.annotation.Configuration;
import org.rishabh.t.utility.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Configuration
public class CompanyConsumer extends Consumer{

    @Override
    public void consume() {
        try{
            Collection<String> topics = new ArrayList<>(Arrays.asList(Constants.Topics.COMPANY_TOPIC));
            this.getKafkaConsumer().subscribe(topics);
            while (true) {
                ConsumerRecords <String, Company> companyConsumerRecords = (ConsumerRecords <String, Company>)this.getKafkaConsumer().poll(100);
                for (ConsumerRecord <String, Company> companyConsumerRecord : companyConsumerRecords) {
                    System.out.println("key: " + companyConsumerRecord.key());
                    System.out.println("value: " + companyConsumerRecord.value());
                }
                this.getKafkaConsumer().commitSync();
            }
        }finally {
            this.getKafkaConsumer().close();
        }
    }
}
