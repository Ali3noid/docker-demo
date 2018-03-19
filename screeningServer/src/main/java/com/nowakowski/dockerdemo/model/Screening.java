package com.nowakowski.dockerdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Screening {

    @Id
    @SequenceGenerator(name = "generator-screening-id", sequenceName = "screening-seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator-screening-id")
    private Long id;
    private LocalDateTime startTime;
    private LocalTime duration;
    private String movie;
    private String cinema;
}
