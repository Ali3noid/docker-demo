package com.nowakowski.dockerdemo.message;

import com.google.common.collect.Lists;
import com.nowakowski.dockerdemo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    Message findOneBy(Long id) {
        return repository.findOne(id);
    }

    Message create(Message message) {
        return repository.save(message);
    }

    public List<Message> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    public void update(Message message) {
        repository.save(message);
    }

    public void deleteBy(Long id) {
        repository.delete(id);
    }
}
