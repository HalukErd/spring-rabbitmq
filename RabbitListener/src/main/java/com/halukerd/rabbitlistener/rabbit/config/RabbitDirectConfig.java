package com.halukerd.rabbitlistener.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitDirectConfig {

    @Bean
    public Exchange direct1() {
        return ExchangeBuilder.directExchange("direct1")
                .durable(true)
                .autoDelete()
                .build();
    }

    @Bean
    public Exchange direct2() {
        return ExchangeBuilder.directExchange("direct2")
                .durable(true)
                .autoDelete()
                .build();
    }

    @Bean
    public Queue queue1() {
        return QueueBuilder.durable("queue1").build();
    }

    @Bean
    public Queue queue2() {
        return QueueBuilder.durable("queue2").build();
    }

    @Bean
    public Binding direct1toQueue1() {
        return BindingBuilder
                .bind(queue1())
                .to(direct1())
                .with("key1")
                .noargs();
    }

    @Bean
    public Binding direct1toQueue2() {
        return BindingBuilder
                .bind(queue2())
                .to(direct1())
                .with("key1")
                .noargs();
    }

    @Bean
    public Binding direct2toQueue1() {
        return BindingBuilder
                .bind(queue1())
                .to(direct2())
                .with("key1")
                .noargs();
    }
}
