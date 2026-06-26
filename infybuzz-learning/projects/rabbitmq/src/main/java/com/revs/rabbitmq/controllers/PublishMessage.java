package com.revs.rabbitmq.controllers;

import lombok.*;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PublishMessage {

    private String message;
    private String exchange;
    private String routingKey;
    private String queueName;
    private Map<String, Object> headers;

}
