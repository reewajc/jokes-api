package com.ram.jokes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class JokeController {
    @Autowired
    JokeService jokeService;

    @GetMapping("/jokes")
    public Iterable<Joke> getAll(){
        return jokeService.list();
    }

    @GetMapping("/joke/{id}")
    public Optional<Joke> getJoke(@PathVariable Integer id){
       return jokeService.findJoke(id);
    }
}
