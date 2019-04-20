/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 9:29 PM
*/

package org.rishabh.t.consumer;

import org.rishabh.t.models.Student;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.context.annotation.Configuration;
import org.rishabh.t.utility.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Configuration
public class StudentConsumer extends Consumer{

    @Override
    public void consume() {
        try{
            Collection<String> topics = new ArrayList<>(Arrays.asList(Constants.Topics.STUDENT_TOPIC));
            this.getKafkaConsumer().subscribe(topics);
            while (true) {
                ConsumerRecords<String, Student> studentConsumerRecords = (ConsumerRecords<String, Student>) this.getKafkaConsumer().poll(100);
                for(ConsumerRecord<String, Student> studentRecord : studentConsumerRecords) {
                    System.out.println("key: " + studentRecord.key());
                    System.out.println("Value: " + studentRecord.value());
                }
                this.getKafkaConsumer().commitSync();
            }
        }finally {
            this.getKafkaConsumer().close();
        }
    }
}
