package com.gp.passeios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// Adicionamos @ComponentScan para garantir que o Spring encontre as novas classes
// nos pacotes corretos.
@ComponentScan(basePackages = "com.gp.passeios")
public class GpPasseiosApplication {

    public static void main(String[] args) {
        SpringApplication.run(GpPasseiosApplication.class, args);
    }
}
