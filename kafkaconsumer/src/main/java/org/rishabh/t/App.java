package org.rishabh.t;
/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 7:13 PM
*/


import org.rishabh.t.consumer.ConsumerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    private ConsumerFactory consumerFactory;

    @Autowired
    public App(ConsumerFactory consumerFactory) {
        this.consumerFactory = consumerFactory;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
    @Override
    public void run(String... args) throws Exception {
        String consumerType = (args != null && args.length > 0) ? args[0] : "country";
        this.consumerFactory.getConsumer(Arguments.valueOf(consumerType).getValue()).consume();
    }
}

enum Arguments {
    employee ("Employee"),
    teacher ("Teacher"),
    country ("Country"),
    company ("Company"),
    student ("Student");

    private String value;
    private Arguments(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
