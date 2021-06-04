package com.ani.orm.springdatajpa;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public class DeviceManager {

//    docker run -d --name=influxdb --p 8086:8086 -v  /tmp/testdata/influx:/root/.influxdbv2 --net=influxdb-telegraf-net quay.io/influxdb/influxdb:latest
//    docker run -d --name=telegraf -v /mytelegrafconfigsdir/telegraf.conf:/var/lib/influxdb --net=influxdb-telegraf-net telegraf

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
