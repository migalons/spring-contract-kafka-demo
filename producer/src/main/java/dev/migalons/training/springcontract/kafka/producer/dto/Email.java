package dev.migalons.training.springcontract.kafka.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    private String sender;
    private String receiver;
    private String subject;
    private String body;
}
