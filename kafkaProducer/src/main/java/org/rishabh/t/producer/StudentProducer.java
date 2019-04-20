/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 2:27 AM
*/

package org.rishabh.t.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.rishabh.t.models.Student;
import org.rishabh.t.utility.Constants;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;

import static java.lang.Thread.sleep;

@Configuration
public class StudentProducer extends Producer{

    @Override
    public void produce() throws InterruptedException {
        try{
            Student student = new Student("Rishabh", "India", BigInteger.valueOf(235345345), 122019);
            while(true){
                ProducerRecord<String, Student> studentRecord = new ProducerRecord<>(Constants.Topics.STUDENT_TOPIC, "1", student);
                this.getKafkaProducer().send(studentRecord, (recordMetadata, e) -> {
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
