package dev.migalons.training.springcontract.kafka.consumer;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    private static final Logger log = LoggerFactory.getLogger(Listener.class);

    @KafkaListener(id = "consumerListener", topics = "asyncRequests")
    public void listen(String in) {
        log.info("--------------------------------------------------------------------------------");
        log.info(in);
        log.info("--------------------------------------------------------------------------------");
    }
}
