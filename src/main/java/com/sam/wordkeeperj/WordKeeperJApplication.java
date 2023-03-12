package com.sam.wordkeeperj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class WordKeeperJApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordKeeperJApplication.class, args);
    }
}
