/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 2:27 AM
*/

package org.rishabh.t.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.rishabh.t.models.Teacher;
import org.rishabh.t.utility.Constants;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;

@Configuration
public class TeacherProducer extends Producer{

    @Override
    public void produce() {
        try{
            Teacher teacher = new Teacher("Rishabh", "India", BigInteger.valueOf(64273472), 214211);
            ProducerRecord <String, Teacher> teacherRecord = new ProducerRecord<>(Constants.Topics.TEACHER_TOPIC, "1", teacher);
            this.getKafkaProducer().send(teacherRecord, (recordMetadata, e) -> {
                if(e != null) {
                    e.printStackTrace();
                }
                System.out.println("The offset of the record we just sent is: " + recordMetadata.offset());
            });
        }finally {
            this.getKafkaProducer().close();
        }
    }
}
