package com.halukerd.rabbitretryproject.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.retry.support.RetryTemplateBuilder;

@Configuration
public class RabbitConfig {

    @Bean
    DirectExchange deadLetterExchange() {
        return ExchangeBuilder
                .directExchange("deadLetterExchange")
                .build();
    }
    @Bean
    DirectExchange empExchange() {
        return ExchangeBuilder
                .directExchange("empExchange")
                .build();
    }

    @Bean
    Queue deadLetterQueue() {
        return QueueBuilder
                .durable("deadLetter.queue").build();
    }

    @Bean
    Queue empQueue() {
        return QueueBuilder
                .durable("emp.queue")
                .withArgument("x-dead-letter-exchange", "deadLetterExchange")
                .withArgument("x-dead-letter-routing-key", "deadLetterRoutingKey")
                .build();
    }

    @Bean
    Binding deadLetterBinding() {
        return BindingBuilder
                .bind(deadLetterQueue())
                .to(deadLetterExchange())
                .with("deadLetterRoutingKey");
    }

    @Bean
    Binding empBinding() {
        return BindingBuilder
                .bind(empQueue())
                .to(empExchange())
                .with("empRoutingKey");
    }

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public MessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        return simpleMessageListenerContainer;
    }

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
