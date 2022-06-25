package com.halukerd.rabbitlistener.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopicConfig {
   @Bean
   public TopicExchange topic1() {
       return ExchangeBuilder
               .topicExchange("topic1")
               .build();
   }


   @Bean
   Queue marketingQueue() {
       return QueueBuilder.durable("marketingQueue").build();
   }
   @Bean
   Queue financeQueue() {
       return QueueBuilder.durable("financeQueue").build();
   }
   @Bean
   Queue adminQueue() {
       return QueueBuilder.durable("adminQueue").build();
   }
   @Bean
   Queue allQueue() {
       return QueueBuilder.durable("allQueue").build();
   }

   @Bean
   Binding marketingBinding() {
       return BindingBuilder.bind(marketingQueue()).to(topic1()).with("queue.topic.marketing");
   }


    @Bean
    Binding financeBinding() {
        return BindingBuilder.bind(financeQueue()).to(topic1()).with("queue.topic.finance");
    }
    @Bean
    Binding adminBinding() {
        return BindingBuilder.bind(adminQueue()).to(topic1()).with("queue.topic.admin");
    }

    @Bean
    Binding allBinding() {
        return BindingBuilder.bind(allQueue()).to(topic1()).with("queue.topic.*");
    }
}
