package dev.eklak.springjpaexample;

import dev.eklak.springjpaexample.repositories.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaExampleApplication implements CommandLineRunner {

    @Autowired
    private PersonJpaRepository personJpaRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringJpaExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var person = personJpaRepository.findById(10001);
        System.out.println("The person with ID 10001 is " + person.toString());
    }
}
