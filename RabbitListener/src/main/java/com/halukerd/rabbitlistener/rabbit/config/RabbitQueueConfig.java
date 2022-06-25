package com.halukerd.rabbitlistener.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitQueueConfig {
    @Bean
    Queue ExampleQueue() {
        return new Queue("ExampleQueue", false);
    }

    @Bean
    Queue ExampleSecondQueue() {
        return QueueBuilder
                .durable("ExampleSecondQueue")
                .autoDelete()
                .exclusive()
                .build();
    }

}
