package com.epam;

import com.epam.repo.WordsRepo;
import com.epam.repo.WordsRepoImpl;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Evgeny Borisov
 */
@SpringBootApplication
public class MainApp {


    @Bean
    public SparkContext sc(){
        return new SparkContext(new SparkConf().setMaster("local[*]").setAppName("music"));
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class);
    }
}
