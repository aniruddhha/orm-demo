package com.ani.orm.springdatajpa;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public class DeviceManager {

    private final DeviceRepository repository;

    public DeviceManager(
            DeviceRepository repository
    ) {
        this.repository = repository;
    }

    public void save() {
        repository.save(
                new Device(1L, "abc", Date.from(Instant.now()) )
        );
    }

    public void all() {
        repository.findAll().forEach(System.out::println);
    }
}
