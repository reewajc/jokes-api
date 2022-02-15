package com.ram.jokes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class JokesApplication {

    @Value("classpath:data/jokes.json")
    private Resource resourceFile;

    @Autowired
    JokeService jokeService;

    public static void main(String[] args) {
        SpringApplication.run(JokesApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return  args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Joke>> typeReference = new TypeReference<List<Joke>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/data/jokes.json");
            try {
                List<Joke> users = mapper.readValue(inputStream,typeReference);
                jokeService.save(users);
                //System.out.println(users.stream().collect(Collectors.toList()));

            } catch (IOException e){
                System.out.println("Unable to save users: " + e.getMessage());
            }

        };
    }

}
