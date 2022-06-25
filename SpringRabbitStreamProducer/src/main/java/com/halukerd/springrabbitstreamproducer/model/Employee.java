package com.halukerd.springrabbitstreamproducer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties
@Data
@ToString
public class Employee {
    private String empName;
    private String empId;
}
