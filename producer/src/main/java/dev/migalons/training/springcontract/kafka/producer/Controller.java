package dev.migalons.training.springcontract.kafka.producer;

import dev.migalons.training.springcontract.kafka.producer.dto.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static Logger log = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private MessageSubmitter messageSubmitter;
    
    @PostMapping("/email")
    public void postMessage(@RequestBody Email email) {
        log.info("Got POST /email: ");
        log.info("sender: " + email.getSender());
        log.info("receiver: " + email.getReceiver());
        log.info("subject: " + email.getSubject());
        messageSubmitter.send(email);
    }
}
