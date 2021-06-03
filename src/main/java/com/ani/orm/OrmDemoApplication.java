package com.ani.orm;

import com.ani.orm.springdatajpa.DeviceManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmDemoApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OrmDemoApplication.class, args);
		DeviceManager mgr = ctx.getBean(DeviceManager.class);
		mgr.save();
		mgr.all();
	}
}
