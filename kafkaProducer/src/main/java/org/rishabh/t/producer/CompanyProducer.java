/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 2:28 AM
*/

package org.rishabh.t.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.rishabh.t.models.Company;
import org.rishabh.t.utility.Constants;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;

import static java.lang.Thread.sleep;

@Configuration
public class CompanyProducer extends Producer{

    @Override
    public void produce() throws InterruptedException {
        try{
            Company companyRecord = new Company("Kafka Company", "India", BigInteger.valueOf(111111111), 76423.2345, 1,4334636.3466);
            while (true) {
                ProducerRecord<String, Company> companyProducerRecord = new ProducerRecord<>(Constants.Topics.COMPANY_TOPIC, "1", companyRecord);
                this.getKafkaProducer().send(companyProducerRecord, (RecordMetadata metadata, Exception e) -> {
                    if(e != null)
                        e.printStackTrace();
                    System.out.println("The offset of the record we just sent is: " + metadata.offset());
                });
                sleep(1000);
            }
        }finally {
            this.getKafkaProducer().close();
        }
    }
}
