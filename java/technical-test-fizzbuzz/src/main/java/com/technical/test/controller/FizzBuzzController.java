package com.technical.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class FizzBuzzController {
    private static final Logger logger = LoggerFactory.getLogger(FizzBuzzController.class);

    // Endpoint fizzbuzz with optional parameters
    @RequestMapping(value = "/fizzbuzz", method = RequestMethod.GET)
    public List<String> fizzbuzz(@RequestParam Optional<Integer> int1, Optional<Integer> int2, Optional<Integer> limit, Optional<String> str1, Optional<String> str2)
    {
        List<String> result = new ArrayList<>();
        for (Integer i = 1; i <= limit.orElseGet(() -> 100); i++) {
            result.add(fizzBuzzOrNumber(i, int1.orElseGet(() -> 3), int2.orElseGet(() -> 5),
                    str1.orElseGet(() -> "fizz"), str2.orElseGet(() -> "buzz")));
        }
        return result;
    }

    // Function that return the right value according to the multiple
    public String fizzBuzzOrNumber(Integer value, Integer int1, Integer int2, String str1, String str2) {
        boolean multiple1 = isMultiple(value, int1);
        boolean multiple2 = isMultiple(value, int2);
        String result = "";
        logger.debug("For values: value(" + value + "), int1(" + int1 + ") and int2(" + int2 +
                ") with possible return: str1(" + str1 + ") and str2(" + str2 + ")");

        if (multiple1 && multiple2){
            result =  str1 + str2;
        } else if (multiple1) {
            result = str1;
        } else if (multiple2) {
            result = str2;
        } else {
            result = String.valueOf(value);
        }
        logger.debug("result is: " + result);
        return result;
    }

    // Function to verify if the number is multiple of compare value
    public boolean isMultiple(Integer number, Integer compare){
        return number % compare == 0;
    }
}
