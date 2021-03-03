package dev.migalons.training.springcontract.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.migalons.training.springcontract.kafka.consumer.dto.Email;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.stereotype.Component;

@Component
public class MessageSubmitter {

    private static final Logger log = LoggerFactory.getLogger(MessageSubmitter.class);

    private final ReplyingKafkaTemplate<String, String, String> template;
    private final ObjectMapper objectMapper;

    public MessageSubmitter(ReplyingKafkaTemplate<String, String, String> template, ObjectMapper objectMapper) {
        this.template = template;
        this.objectMapper = objectMapper;
    }

    public void send(Email email) {
        try {
            ProducerRecord<String, String> record = new ProducerRecord<>("asyncRequests", objectMapper.writeValueAsString(email));
            record.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, "asyncReplies".getBytes()));
            template.send(record);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

}
