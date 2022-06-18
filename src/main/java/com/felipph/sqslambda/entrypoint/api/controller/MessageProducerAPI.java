package com.felipph.sqslambda.entrypoint.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class MessageProducerAPI {
    private final JmsTemplate defaultJmsTemplate;

    @Value("${consumer.sqs.message.queue.name}")
    private String queue;


    public MessageProducerAPI(JmsTemplate defaultJmsTemplate) {
        this.defaultJmsTemplate = defaultJmsTemplate;
    }

    @GetMapping("envia")
    ResponseEntity<String> putMessage(@RequestParam("msg") String message) {
        JmsMessagingTemplate template = new JmsMessagingTemplate(this.defaultJmsTemplate);
        Map<String, Object> headers = new HashMap<>();
        headers.put("JMSXGroupID", "2");
        headers.put("JMS_SQS_DeduplicationId", UUID.randomUUID().toString());
        template.convertAndSend(queue, message, headers);
        return ResponseEntity.ok("Enviado: "+message);
    }
}
