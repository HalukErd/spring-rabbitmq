package com.halukerd.rabbitmqdemo.controller;

import com.halukerd.rabbitmqdemo.controller.request.RabbitMessage;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
@Log4j2
public class HelloController {

    private RabbitTemplate rabbitTemplate;

    @PostMapping("/rabbit")
    public ResponseEntity sendMessage(@RequestBody RabbitMessage message, @RequestParam(required = false) String department) {
        log.info("logging" + message.getName());

        if (Strings.isNotEmpty(department)) { // Headers Exchange
            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setHeader("department", department);
            MessageConverter messageConverter = new Jackson2JsonMessageConverter();
            Message message1 = messageConverter.toMessage(message, messageProperties);
            rabbitTemplate.setMessageConverter(messageConverter);
            rabbitTemplate.convertAndSend(message.getExchange(), "", message1);
        }

        if (Strings.isNotEmpty(message.getExchange())) {
            // common usage
            rabbitTemplate.convertAndSend(message.getExchange(), message.getRoutingKey(), message);
        }else {
            // to send without exchange name
            rabbitTemplate.convertAndSend(message.getRoutingKey(), message);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
