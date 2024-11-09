package com.multi.oompadatalunch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.multi.oompaglobal","com.multi.oompadatalunch"})
public class OompaDataLunchApplication {

	public static void main(String[] args) {
		SpringApplication.run(OompaDataLunchApplication.class, args);
	}

}
