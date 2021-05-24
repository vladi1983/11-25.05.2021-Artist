package com.epam.controllers;

import com.epam.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
@RestController
public class MusicJudgeController {
    @Autowired
    private MusicService musicService;

    @GetMapping("/music/topx/{artist}/{x}")
    public Map<String, Integer> topX(@PathVariable String artist, @PathVariable int x) {
        scala.collection.immutable.Map<String, Object> scalaMap = musicService.topXWithRate(artist, x);
        Map<String, Integer> map = new HashMap<>();

        scalaMap.foreach(v1 -> map.put(v1._1, (Integer) v1._2));
        return map;
    }
}












