package com.bac.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class KafkaProducerController {
	
	@Autowired
	private KafkaTemplate<String, String> template;
	
	private final String TOPIC_NAME = "items-topic2";
	
	@GetMapping("/say/{msg}")
	public String produceMessage(@PathVariable("msg") String msg) {
		template.send(TOPIC_NAME, msg);
		return "Message published successfully";
	}

}