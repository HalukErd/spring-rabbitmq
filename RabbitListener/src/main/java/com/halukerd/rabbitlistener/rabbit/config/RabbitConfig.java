package com.halukerd.rabbitlistener.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String MY_QUEUE = "MyQueue";

    @Bean
    Queue myQueue() {
        return new Queue(MY_QUEUE);
    }

    @Bean
    Exchange myExchange() {
        return ExchangeBuilder
                .topicExchange("myTopicExchange")
                .durable(true)
                .build();
    }

    @Bean
    Binding binding() {
        return BindingBuilder
                .bind(myQueue())
                .to(myExchange())
                .with("topicBinding")
                .noargs();
    }

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

//    @Bean("messageListenerContainer")
//    MessageListenerContainer messageListenerContainer(ObjectMapper objectMapper) {
//        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
//        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
//        simpleMessageListenerContainer.setQueues(myQueue());
//        simpleMessageListenerContainer.setMessageListener(new RabbitListener(jackson2JsonMessageConverter(), objectMapper));
//        return simpleMessageListenerContainer;
//    }

    @Bean
    public MessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        return simpleMessageListenerContainer;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory defaultContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);

        return factory;
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
