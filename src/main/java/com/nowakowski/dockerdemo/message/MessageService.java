package com.nowakowski.dockerdemo.message;

import com.nowakowski.dockerdemo.model.Author;
import com.nowakowski.dockerdemo.model.Message;
import org.springframework.stereotype.Service;

@Service
class MessageService {

    Message findOne() {
        return Message.builder()
                .author(Author.builder()
                        .firstName("Rafał")
                        .lastName("Nowakowski")
                        .age(27)
                        .build())
                .text("Turbo Fun")
                .build();
    }
}
