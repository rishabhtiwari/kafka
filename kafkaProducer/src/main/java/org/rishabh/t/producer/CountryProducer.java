/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 2:24 AM
*/

package org.rishabh.t.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.rishabh.t.models.Country;
import org.rishabh.t.utility.Constants;
import org.springframework.context.annotation.Configuration;

import static java.lang.Thread.sleep;

@Configuration
public class CountryProducer extends Producer {

    @Override
    public void produce() throws InterruptedException {
        try {
            Country country = new Country("India", "Modi", 91, "Delhi", 2000.0, 5);
            while (true){
                ProducerRecord<String, Country> countryRecord = new ProducerRecord<>(Constants.Topics.COUNTRY_TOPIC, "1", country);
                this.getKafkaProducer().send(countryRecord, (recordMetadata, e) -> {
                    if(e != null) {
                        e.printStackTrace();
                    }
                    System.out.println("The offset of the record we just sent is: " + recordMetadata.offset());
                });
                sleep(1000);
            }
        }finally {
            this.getKafkaProducer().close();
        }
    }
}
