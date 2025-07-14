package org.oab.catracaoab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CatracaOabApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatracaOabApplication.class, args);
    }

}
