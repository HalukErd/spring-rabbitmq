package com.halukerd.rabbitlistener.rabbit.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitListeners {

    private ObjectMapper objectMapper;

    @RabbitListener(queues = "queue1", containerFactory = "defaultContainerFactory")
    public void receivedFromQueue1(Message message) throws JsonProcessingException {
        String json = new String(message.getBody());
        RabbitMessage rabbitMessage = objectMapper.readValue(json, RabbitMessage.class);
        log.info("receivedFromQueue1 received: " + rabbitMessage);
    }

    @RabbitListener(queues = "queue2", containerFactory = "defaultContainerFactory")
    public void receivedFromQueue2(Message message) throws JsonProcessingException {
        String json = new String(message.getBody());
        RabbitMessage rabbitMessage = objectMapper.readValue(json, RabbitMessage.class);
        log.info("receivedFromQueue2 received: " + rabbitMessage);
    }

    @RabbitListener(queues = "queue3", containerFactory = "defaultContainerFactory")
    public void receivedFromQueue3(Message message) throws JsonProcessingException {
        String json = new String(message.getBody());
        RabbitMessage rabbitMessage = objectMapper.readValue(json, RabbitMessage.class);
        log.info("receivedFromQueue3 received: " + rabbitMessage);
    }

    @RabbitListener(queues = "queue4", containerFactory = "defaultContainerFactory")
    public void receivedFromQueue4(Message message) throws JsonProcessingException {
        String json = new String(message.getBody());
        RabbitMessage rabbitMessage = objectMapper.readValue(json, RabbitMessage.class);
        log.info("receivedFromQueue4 received: " + rabbitMessage);
    }

    @RabbitListener(queues = "queue5", containerFactory = "defaultContainerFactory")
    public void receivedFromQueue5(Message message) throws JsonProcessingException {
        String json = new String(message.getBody());
        RabbitMessage rabbitMessage = objectMapper.readValue(json, RabbitMessage.class);
        log.info("receivedFromQueue5 received: " + rabbitMessage);
    }

    @RabbitListener(queues = "queue6", containerFactory = "defaultContainerFactory")
    public void receivedFromQueue6(Message message) throws JsonProcessingException {
        String json = new String(message.getBody());
        RabbitMessage rabbitMessage = objectMapper.readValue(json, RabbitMessage.class);
        log.info("receivedFromQueue6 received: " + rabbitMessage);
    }

    @RabbitListener(queues = "marketingQueue", containerFactory = "defaultContainerFactory")
    public void receivedFromMarketingQueue(Message message) throws JsonProcessingException {
        String json = new String(message.getBody());
        RabbitMessage rabbitMessage = objectMapper.readValue(json, RabbitMessage.class);
        log.info("marketingQueue received: " + rabbitMessage);
    }

    @RabbitListener(queues = "financeQueue", containerFactory = "defaultContainerFactory")
    public void receivedFromFinanceQueue(Message message) throws JsonProcessingException {
        String json = new String(message.getBody());
        RabbitMessage rabbitMessage = objectMapper.readValue(json, RabbitMessage.class);
        log.info("financeQueue received: " + rabbitMessage);
    }

    @RabbitListener(queues = "adminQueue", containerFactory = "defaultContainerFactory")
    public void receivedFromAdminQueue(Message message) throws JsonProcessingException {
        String json = new String(message.getBody());
        RabbitMessage rabbitMessage = objectMapper.readValue(json, RabbitMessage.class);
        log.info("adminQueue received: " + rabbitMessage);
    }

    @RabbitListener(queues = "allQueue", containerFactory = "defaultContainerFactory")
    public void receivedFromAllQueue(Message message) throws JsonProcessingException {
        String json = new String(message.getBody());
        RabbitMessage rabbitMessage = objectMapper.readValue(json, RabbitMessage.class);
        log.info("allQueue received: " + rabbitMessage);
    }
}