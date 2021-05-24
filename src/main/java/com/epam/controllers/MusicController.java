package com.epam.controllers;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
@RestController
public class MusicController {

    @Autowired
    private WordService wordService;

    @Autowired
    private JavaSparkContext sc;

    @GetMapping("music/top/")
    public List<String> topX(/*String pathToData, int x*/) {
        JavaRDD<String> rdd = sc.parallelize(List.of("Java","Python", "Java", "Java", "Scala", "Scala"));
        Iterator<String> wordsIterator = wordService.topX(rdd.rdd(), 2).iterator();
        List<String> words = new ArrayList<>();
        while (wordsIterator.hasNext()) {
            String word = wordsIterator.next();
            words.add(word);
        }

        return words;
        //todo finish it
    }
}
