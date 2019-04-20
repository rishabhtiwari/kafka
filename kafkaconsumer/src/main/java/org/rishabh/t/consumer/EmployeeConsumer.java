/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 9:31 PM
*/

package org.rishabh.t.consumer;

import org.rishabh.t.models.Employee;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.context.annotation.Configuration;
import org.rishabh.t.utility.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Configuration
public class EmployeeConsumer extends Consumer{

    @Override
    public void consume() {
        try{
            Collection<String> topics = new ArrayList<>(Arrays.asList(Constants.Topics.EMPLOYEE_TOPIC));
            this.getKafkaConsumer().subscribe(topics);
            while (true) {
                ConsumerRecords <String, Employee> employeeConsumerRecords = (ConsumerRecords <String, Employee>) this.getKafkaConsumer().poll(100);
                for (ConsumerRecord<String, Employee> employeeConsumerRecord : employeeConsumerRecords) {
                    System.out.println("key: " + employeeConsumerRecord.key());
                    System.out.println("value: " + employeeConsumerRecord.value());
                }
                this.getKafkaConsumer().commitSync();
            }
        }finally {
            this.getKafkaConsumer().close();
        }
    }
}
