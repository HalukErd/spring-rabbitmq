package com.halukerd.rabbitmqdemo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitmqdemoApplication implements CommandLineRunner {

    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqdemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        rabbitTemplate.convertAndSend("TestExchange", "testRouting", "Started rabbit project");
    }
}
