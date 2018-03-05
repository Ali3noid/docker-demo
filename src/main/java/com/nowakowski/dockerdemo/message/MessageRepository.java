package com.nowakowski.dockerdemo.message;

import com.nowakowski.dockerdemo.model.Message;
import org.springframework.data.repository.CrudRepository;

interface MessageRepository extends CrudRepository<Message, Long> {
    //
}
