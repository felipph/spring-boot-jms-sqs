package com.felipph.sqslambda.entrypoint.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JMSConsumer {
    @JmsListener(destination = "${consumer.sqs.message.default-queue-name}")
    public void messageConsumer(@Headers Map<String, Object> messageAttributes,
                                @Payload String message) {
        // Do something
        System.out.println("Messages attributes: " + messageAttributes);
        System.out.println("Body: " + message);
    }
}
