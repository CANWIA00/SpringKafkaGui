package com.canwia.springkafkagui.kafka;

import com.canwia.springkafkagui.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);



    @KafkaListener(topics = "javaguides_json", groupId = "myGroup")
    public void consume(Users users){
        LOGGER.info(String.format("Json message recieved -> %s", users.toString()));
    }


}
