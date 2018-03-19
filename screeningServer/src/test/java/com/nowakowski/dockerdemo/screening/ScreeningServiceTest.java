package com.nowakowski.dockerdemo.screening;

import com.nowakowski.dockerdemo.model.Screening;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ScreeningServiceTest {

    @Autowired
    private ScreeningService service;


    @Test
    public void createTestRecord() {
        service.create(Screening
                .builder()
                .cinema("Plaza")
                .duration(LocalTime.of(2, 19))
                .startTime(LocalDateTime.of(2018, 3, 13, 20, 30))
                .movie("Kobiety Mafii")
                .build());
    }

}