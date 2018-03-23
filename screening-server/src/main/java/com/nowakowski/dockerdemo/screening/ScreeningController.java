package com.nowakowski.dockerdemo.screening;

import com.google.common.base.Preconditions;
import com.nowakowski.dockerdemo.model.Screening;
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
 class ScreeningController {

    private final ScreeningService service;

    @Autowired
    public ScreeningController(ScreeningService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public List<Screening> retrieveAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Screening retrieveOne(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound(service.findOneBy(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long create(@RequestBody Screening screening) {
        Preconditions.checkNotNull(screening);
        return service.create(screening).getId();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody Screening screening) {
        Preconditions.checkNotNull(screening);
        RestPreconditions.checkFound(service.findOneBy(screening.getId()));
        service.update(screening);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteBy(id);
    }
}
