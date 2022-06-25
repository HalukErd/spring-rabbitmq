package com.halukerd.rabbitlistener.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitFanoutConfig {

    @Bean
    public FanoutExchange fanoutExchange1() {
        return ExchangeBuilder
                .fanoutExchange("fanout1")
                .autoDelete()
                .durable(true)
                .build();
    }

    @Bean
    public FanoutExchange fanoutExchange2() {
        return ExchangeBuilder
                .fanoutExchange("fanout2")
                .autoDelete()
                .durable(true)
                .build();
    }

    @Bean
    public Queue queue3() {
        return QueueBuilder.durable("queue3").build();
    }

    @Bean
    public Queue queue4() {
        return QueueBuilder.durable("queue4").build();
    }

    @Bean
    public Binding fanout1toQueue3() {
        return BindingBuilder
                .bind(queue3())
                .to(fanoutExchange1());
    }

    @Bean
    public Binding fanout1toQueue4() {
        return BindingBuilder
                .bind(queue4())
                .to(fanoutExchange1());
    }
}
