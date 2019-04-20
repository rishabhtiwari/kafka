package org.rishabh.t;

import org.rishabh.t.producer.ProducerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
1) Employee
2) Student
3) Teacher
4) Company
5) Country
 */
@SpringBootApplication
public class App implements CommandLineRunner {

    private final ProducerFactory producerFactory;

    @Autowired
    public App(ProducerFactory producerFactory) {
        this.producerFactory = producerFactory;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String producerName = (args != null && args.length > 0) ? args[0].toLowerCase() : "country";
        this.producerFactory.getProducer(Arguments.valueOf(producerName).getValue()).produce();
    }
}

enum Arguments {

    employee("Employee"),
    student("Student"),
    teacher("Teacher"),
    company("Company"),
    country("Country");

    private String value;
    private Arguments(String value) {
       this.value = value;
    }

    public String getValue() {
        return value;
    }
}
