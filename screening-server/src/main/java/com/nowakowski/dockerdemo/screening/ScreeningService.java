package com.nowakowski.dockerdemo.screening;

import com.google.common.collect.Lists;
import com.nowakowski.dockerdemo.model.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningService {

    private final ScreeningRepository repository;

    @Autowired
    public ScreeningService(ScreeningRepository repository) {
        this.repository = repository;
    }

    Screening findOneBy(Long id) {
        return repository.findOne(id);
    }

    Screening create(Screening screening) {
        return repository.save(screening);
    }

    public List<Screening> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    public void update(Screening screening) {
        repository.save(screening);
    }

    public void deleteBy(Long id) {
        repository.delete(id);
    }
}
