package com.nowakowski.dockerdemo.message;

import com.nowakowski.dockerdemo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "message")
public class MessageController {

    private final MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping
    public Message findOne() {
        return service.findOne();
    }
}
