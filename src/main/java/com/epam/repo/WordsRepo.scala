package com.epam.repo

import org.apache.spark.rdd.RDD

/**
 * @author Evgeny Borisov
 */
trait WordsRepo {
  def allLines(musicianName: String): RDD[String]
}
