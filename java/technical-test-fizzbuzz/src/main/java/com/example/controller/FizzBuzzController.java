package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class FizzBuzzController {
    private static final Logger logger = LoggerFactory.getLogger(FizzBuzzController.class);

    // Endpoint fizzbuzz with optional parameters
    @RequestMapping(value = "/fizzbuzz", method = RequestMethod.GET)
    public List<String> fizzbuzz(@RequestParam Optional<Integer> int1, Optional<Integer> int2, Optional<Integer> limit, Optional<String> str1, Optional<String> str2)
    {
        List<String> result = new ArrayList<>();
        for (Integer i = 1; i <= limit.orElseGet(() -> 100); i++) {
            if (isMultiple(i, int1.orElseGet(() -> 3)) && isMultiple(i, int2.orElseGet(() -> 5))){
                result.add(str1.orElseGet(() -> "fizz") + str2.orElseGet(() -> "buzz"));
            } else if (isMultiple(i, int1.orElseGet(() -> 3))) {
                result.add(str1.orElseGet(() -> "fizz"));
            } else if (isMultiple(i, int2.orElseGet(() -> 5))) {
                result.add(str2.orElseGet(() -> "buzz"));
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    // Function to verify if the number is multiple of compare value
    public boolean isMultiple(Integer number, Integer compare){
        return number % compare == 0;
    }
}
