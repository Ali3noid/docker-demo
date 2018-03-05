package com.nowakowski.dockerdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @SequenceGenerator(name="generator-message-id", sequenceName="message-seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generator-message-id")
    private Long id;
    private String text;
}
