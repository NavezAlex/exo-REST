package com.example.tffsjavarestapi;

import com.example.tffsjavarestapi.models.entities.Author;
import com.example.tffsjavarestapi.models.entities.Book;
import com.example.tffsjavarestapi.models.entities.User;
import com.example.tffsjavarestapi.repositories.AuthorRepository;
import com.example.tffsjavarestapi.repositories.BookRepository;
import com.example.tffsjavarestapi.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableScheduling
@ConfigurationPropertiesScan
public class TffsJavaRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TffsJavaRestApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository ur, PasswordEncoder encoder) {
        return (String[] args) -> {
//            User user = new User();
//            user.setUsername("Ovyn");
//            user.setPassword(encoder.encode("Flavian"));
//            ur.save(user);
        };
    }
}
