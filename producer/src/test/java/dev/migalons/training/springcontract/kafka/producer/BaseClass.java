package dev.migalons.training.springcontract.kafka.producer;

import dev.migalons.training.springcontract.kafka.producer.dto.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMessageVerifier
@EmbeddedKafka(partitions = 1, topics = {"asyncRequests"})
@ActiveProfiles("test")
public class BaseClass {


    @Autowired
    Controller controller;

    public void trigger() {
        Email email = new Email("me@mail.com", "you@mail.com", "Hello world!", null);
        this.controller.postMessage(email);
    }

}
