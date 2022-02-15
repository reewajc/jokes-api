package com.ram.jokes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JokeService {
    @Autowired
    private JokeRepository jokeRepository;


    public Iterable<Joke> list() {
        return jokeRepository.findAll();
    }

    public Iterable<Joke> save(List<Joke> jokes) {
        return jokeRepository.saveAll(jokes);
    }

    public Optional<Joke> findJoke(Integer id){
        return jokeRepository.findById(id);
    }
}
