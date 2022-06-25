package com.halukerd.rabbitlistener.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitHeaderConfig {
    @Bean
    public HeadersExchange headersExchange1() {
        return ExchangeBuilder
                .headersExchange("headers1")
                .durable(true)
                .build();
    }

    @Bean
    public Queue queue5() {
        return QueueBuilder.durable("queue5").build();
    }

    @Bean
    public Queue queue6() {
        return QueueBuilder.durable("queue6").build();
    }

    @Bean
    public Binding headersABinding() {
        return BindingBuilder
                .bind(queue5())
                .to(headersExchange1())
                .where("department")
                .matches("A");
    }

    @Bean
    public Binding headersBBinding() {
        return BindingBuilder
                .bind(queue6())
                .to(headersExchange1())
                .where("department")
                .matches("B");
    }
}
