package dev.migalons.training.springcontract.kafka.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

//    @Bean
//    public ReplyingKafkaTemplate<String, String, String> kafkaTemplate(
//            ProducerFactory<String, String> pf,
//            KafkaMessageListenerContainer<String, String> replyContainer) {
//        return new ReplyingKafkaTemplate<>(pf, replyContainer);
//    }

//    @Bean
//    public KafkaMessageListenerContainer<String, String> replyContainer(
//            ConsumerFactory<String, String> cf) {
//        ContainerProperties containerProperties = new ContainerProperties("asyncReplies");
//        containerProperties.setGroupId("async");
//        return new KafkaMessageListenerContainer<>(cf, containerProperties);
//    }

    @Bean
    public NewTopic asyncRequests() {
        return new NewTopic("asyncRequests", 1, (short) 1);
    }

//    @Bean
//    public NewTopic asyncReplies() {
//        return new NewTopic("asyncReplies", 1, (short) 1);
//    }

}
