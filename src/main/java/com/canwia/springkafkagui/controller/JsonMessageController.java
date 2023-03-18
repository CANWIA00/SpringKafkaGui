package com.canwia.springkafkagui.controller;

import com.canwia.springkafkagui.kafka.JsonKafkaProducer;
import com.canwia.springkafkagui.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/kafka/message")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }


    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Users users){
        jsonKafkaProducer.sendMessage(users);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
