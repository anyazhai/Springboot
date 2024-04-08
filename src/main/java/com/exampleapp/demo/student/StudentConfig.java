package com.exampleapp.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean //needed for it to run
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student maya = new Student(
                    "Maya",
                    LocalDate.of(2000, Month.AUGUST, 23),
                    "maya@gmail.com"
            );
            Student anya = new Student(
                    "Anya",
                    LocalDate.of(2005, Month.AUGUST, 23),
                    "anya@gmail.com"
            );

            repository.saveAll(
                    List.of(maya, anya)
            );

        };
    }
}
