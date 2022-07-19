package com.intelcia.test.mssiret;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MsSiretApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSiretApplication.class, args);
	}

}
