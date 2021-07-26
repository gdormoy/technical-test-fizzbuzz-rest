package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FizzBuzzController {
    private static final Logger logger = LoggerFactory.getLogger(FizzBuzzController.class);

    @RequestMapping(value = "/fizzbuzz", method = RequestMethod.GET)
    public List<String> fizzbuzz(@RequestParam Integer int1, Integer int2, Integer limit, String str1, String str2)
    {
        List<String> result = new ArrayList<>();
        for (Integer i = 1; i <= limit; i++) {
            if (i % int1 == 0 && i % int2 == 0){
                result.add(str1 + str2);
            } else if (i % int1 == 0) {
                result.add(str1);
            } else if (i % int2 == 0) {
                result.add(str2);
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
