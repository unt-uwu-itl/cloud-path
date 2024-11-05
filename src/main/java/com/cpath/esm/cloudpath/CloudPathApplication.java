package com.cpath.esm.cloudpath;

import com.cpath.esm.cloudpath.cli.CommandLineInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CloudPathApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudPathApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            CommandLineInterface cli = context.getBean(CommandLineInterface.class);
            cli.run();
        };
    }
}
