package com.cpath.esm.cloudpath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

@CommandScan
@SpringBootApplication
public class CloudPathApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudPathApplication.class, args);
    }
}
