package com.halukerd.springrabbitstreamconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
@Slf4j
public class SpringRabbitStreamConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRabbitStreamConsumerApplication.class, args);
    }

    @StreamListener(target = Sink.INPUT)
    public void processRegisterEmployees(String employee) {
        log.info("Employees registered by client " + employee);
    }
}
