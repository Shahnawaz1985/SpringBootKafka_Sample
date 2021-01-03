package com.bac.sample.boots.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.bac.spring.boot.model.Item;

@Service
public class KafkaConsumerService {
	
	
	@KafkaListener(topics = "items-topic2", groupId = "test-consumer-group", containerFactory = "kafkaItemListener")
	public void consumeItem(Item item) {
		System.out.println("Consumed Message :" + item);
	}
	
	
	@KafkaListener(topics = "items-topic1", groupId = "test-consumer-group",containerFactory = "kafkaStringListener")
    public void consumeString(String item){
        System.out.println("Consumed Message :"+item);
    }

}