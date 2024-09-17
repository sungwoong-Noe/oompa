package com.multi.oompadataarticle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OompaDataArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OompaDataArticleApplication.class, args);
	}

}
