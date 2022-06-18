package com.felipph.sqslambda.entrypoint.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class S3EventListener {


    @JmsListener(destination = "${consumer.sqs.message.s3-create-file}")
    public void onCreateS3FileEvent(@Headers Map<String, Object> messageAttributes,
                                @Payload String message) {
        // Do something
        System.out.println("Messages attributes: " + messageAttributes);
        System.out.println("Body: " + message);
    }

    @JmsListener(destination = "${consumer.sqs.message.s3-delete-file}")
    public void onDeleteS3FileEvent(@Headers Map<String, Object> messageAttributes,
                                    @Payload String message) {
        // Do something
        System.out.println("Messages attributes: " + messageAttributes);
        System.out.println("Body: " + message);
    }
}
