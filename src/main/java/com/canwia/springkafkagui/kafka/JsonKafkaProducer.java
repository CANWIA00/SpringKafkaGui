package com.canwia.springkafkagui.kafka;

import com.canwia.springkafkagui.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, Users> kafkaTemplate;


    public JsonKafkaProducer(KafkaTemplate<String, Users> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Users data){

        LOGGER.info(String.format("Message sent -> %s",data.toString()));

        Message<Users> message = MessageBuilder
                .withPayload(data)
                        .setHeader(KafkaHeaders.TOPIC,"javaguides_json")
                                .build();

        kafkaTemplate.send(message);
    }
}
