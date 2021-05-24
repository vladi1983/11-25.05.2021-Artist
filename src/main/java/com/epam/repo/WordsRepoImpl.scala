package com.epam.repo

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.springframework.stereotype.Component

@Component
class WordsRepoImpl(sc:SparkContext) extends WordsRepo {

  override def allLines(musicianName: String): RDD[String] = {
    sc.textFile(s"data/songs/$musicianName")
  }
}
