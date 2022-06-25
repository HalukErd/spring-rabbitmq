package com.halukerd.springrabbitstreamproducer.controller;

import com.halukerd.springrabbitstreamproducer.model.Employee;
import com.halukerd.springrabbitstreamproducer.source.EmployeeRegistrationSource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@EnableBinding(EmployeeRegistrationSource.class)
@AllArgsConstructor
@Slf4j
public class EmployeeRegistrationController {

    EmployeeRegistrationSource employeeRegistrationSource;

    @PostMapping(value = "/register")
    public String orderFood(@RequestBody Employee employee) {
        employeeRegistrationSource.employeeRegistration().send(MessageBuilder.withPayload(employee).build());
        log.info(employee.toString());
        return "Employee registered.";
    }
}
