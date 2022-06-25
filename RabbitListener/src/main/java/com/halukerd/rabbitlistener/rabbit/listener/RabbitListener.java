//package com.halukerd.rabbitlistener.rabbit.listener;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.core.MessageListener;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//import javax.annotation.Resource;
//
//
//@Log4j2
//@AllArgsConstructor
//public class RabbitListener implements MessageListener {
//
//    private MessageConverter messageConverter;
//    private ObjectMapper objectMapper;
//
//    @Override
//    public void onMessage(Message message) {
//
//        String json = new String(message.getBody());
//        RabbitMessage rabbitMessage = null;
//        try {
//            rabbitMessage = objectMapper.readValue(json, RabbitMessage.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        log.info("our body: " + rabbitMessage);
//    }
//}
