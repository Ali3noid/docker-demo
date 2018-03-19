package com.nowakowski.dockerdemo.screening;

import com.nowakowski.dockerdemo.model.Screening;
import org.springframework.data.repository.CrudRepository;

interface ScreeningRepository extends CrudRepository<Screening, Long> {
    //
}
