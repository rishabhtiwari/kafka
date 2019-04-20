/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 2:28 AM
*/

package org.rishabh.t.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.rishabh.t.models.Employee;
import org.rishabh.t.utility.Constants;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;

import static java.lang.Thread.sleep;

@Configuration
public class EmployeeProducer extends Producer{

    @Override
    public void produce() throws InterruptedException {
        try{
            Employee employee = new Employee("Rishabh", "India", BigInteger.valueOf(26345643), 234253.235, "s2-b3-d23");
            while(true) {
                ProducerRecord <String, Employee> employeeRecord = new ProducerRecord<>(Constants.Topics.EMPLOYEE_TOPIC, "1", employee);
                this.getKafkaProducer().send(employeeRecord, (recordMetadata, e) -> {
                    if(e != null)
                        e.printStackTrace();
                    System.out.println("The offset of the record we just sent is: " + recordMetadata.offset());
                });
                sleep(1000);
            }
        }finally {
            this.getKafkaProducer().close();
        }
    }
}
