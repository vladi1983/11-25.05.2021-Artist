package com.epam.controllers;
import com.epam.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

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

    @GetMapping("music/compart/{artist1}/{artist2}/{x}")
    public List<String> compareArtist(@PathVariable String artist1, @PathVariable String artist2, @PathVariable int x) {
        List<String> listJava = new ArrayList<>();
        scala.collection.immutable.List<String> listScala = musicService
                .compareBetweenTwoArtists(artist1, artist2, x);
        listScala.foreach(listJava::add);
        return listJava;
    }
}












