package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
       return args -> {
           Student luffy = new Student(
                   "Luffy",
                   19,
                   "luffy@op.com",
                   LocalDate.of(2002, Month.DECEMBER,14));

           Student nami = new Student(
                   "Nami",
                   20,
                   "nami@op.com",
                   LocalDate.of(2001, Month.DECEMBER,1));

           repository.saveAll(List.of(luffy, nami));
       };
    }
}
