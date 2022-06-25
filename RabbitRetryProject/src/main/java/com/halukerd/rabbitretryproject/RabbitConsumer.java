package com.halukerd.rabbitretryproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.halukerd.rabbitretryproject.config.InvalidNameLengthException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitConsumer {

    private ObjectMapper objectMapper;

    @RabbitListener(queues = "emp.queue")
    public void receiveEmp(Message message) throws JsonProcessingException, InvalidNameLengthException {
        String json = new String(message.getBody());
        RabbitMessage rabbitMessage = objectMapper.readValue(json, RabbitMessage.class);
        log.info("received from emp.queue" + rabbitMessage);
        if (rabbitMessage.getName().length() > 10) {
            throw new InvalidNameLengthException();
        }
    }
}