/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 9:41 PM
*/

package org.rishabh.t.consumer;

import org.rishabh.t.models.Teacher;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.context.annotation.Configuration;
import org.rishabh.t.utility.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Configuration
public class TeacherConsumer extends Consumer{

    @Override
    public void consume() {
        try{
            Collection<String> topics = new ArrayList<>(Arrays.asList(Constants.Topics.TEACHER_TOPIC));
            this.getKafkaConsumer().subscribe(topics);
            while (true) {
                ConsumerRecords <String, Teacher> teacherConsumerRecords = (ConsumerRecords <String, Teacher>) this.getKafkaConsumer().poll(100);
                for (ConsumerRecord<String, Teacher> teacherConsumerRecord : teacherConsumerRecords) {
                    System.out.println("key: " + teacherConsumerRecord.key());
                    System.out.println("value: " + teacherConsumerRecord.value());
                }
                this.getKafkaConsumer().commitSync();
            }
        }finally {
            this.getKafkaConsumer().close();
        }
    }
}
