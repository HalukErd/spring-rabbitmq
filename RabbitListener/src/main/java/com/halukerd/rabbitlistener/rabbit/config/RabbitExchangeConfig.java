package com.halukerd.rabbitlistener.rabbit.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitExchangeConfig {
    @Bean
    Exchange exampleExchange() {
        return new TopicExchange("ExampleExchange");
    }

    @Bean
    Exchange exampleSecondExchange() {
        return ExchangeBuilder.directExchange("ExampleSecondExchange")
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    Exchange topicExchange() {
        return ExchangeBuilder.topicExchange("TopicExchange")
                .autoDelete()
                .durable(true)
                .internal()
                .build();
    }

    @Bean
    Exchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange("FanoutExchange")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }

    @Bean
    Exchange headerExchange() {
        return ExchangeBuilder.headersExchange("HeaderExchange")
                .ignoreDeclarationExceptions()
                .durable(true)
                .internal()
                .build();
    }
}
