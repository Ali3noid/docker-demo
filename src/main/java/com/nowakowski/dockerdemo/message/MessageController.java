package com.nowakowski.dockerdemo.message;

import com.google.common.base.Preconditions;
import com.nowakowski.dockerdemo.model.Message;
import com.nowakowski.dockerdemo.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "message")
 class MessageController {

    private final MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public List<Message> retrieveAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Message retrieveOne(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(service.findOneBy(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long create(@RequestBody Message message) {
        Preconditions.checkNotNull(message);
        return service.create(message).getId();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody Message message) {
        Preconditions.checkNotNull(message);
        RestPreconditions.checkFound(service.findOneBy(message.getId()));
        service.update(message);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteBy(id);
    }
}
