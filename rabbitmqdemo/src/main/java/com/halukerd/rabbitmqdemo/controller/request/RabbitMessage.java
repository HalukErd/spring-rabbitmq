package com.halukerd.rabbitmqdemo.controller.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class RabbitMessage implements Serializable {
    private String name;
    private String exchange;
    private String routingKey;
    private String message;
}