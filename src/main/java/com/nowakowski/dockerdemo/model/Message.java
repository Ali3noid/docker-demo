package com.nowakowski.dockerdemo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    private String text;
    private Author author;
}
