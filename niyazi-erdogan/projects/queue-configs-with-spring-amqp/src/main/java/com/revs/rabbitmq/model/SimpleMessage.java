package com.revs.rabbitmq.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SimpleMessage implements Serializable {

    private String message;
    private String description;

}
