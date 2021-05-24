package com.epam.services

import com.epam.repo.WordsRepo
import com.epam.utils.WordsUtil
import org.springframework.stereotype.Component

import scala.collection.JavaConverters.asScalaBufferConverter

/**
 * @author Evgeny Borisov
 */
@Component
class MusicServiceImpl(wordsRepo: WordsRepo) extends MusicService {

  override def topXWithRate(musicianName: String, x: Int): Map[String, Int] = {
    wordsRepo.allLines(musicianName)
      .map(_.toLowerCase())
      .flatMap(line => WordsUtil.getWords(line).asScala)
      .map((_, 1))
      .reduceByKey(_ + _)
      .map(_.swap)
      .sortByKey(ascending = false, 1)
      .map(_.swap)
      .take(x)
      .toMap
  }

  override def topX(musicianName: String, x: Int): List[String] = {
    topXWithRate(musicianName, x).map(_._1).toList
  }

  override def compareBetweenTwoArtists(
                                         musicianName1: String,
                                         musicianName2: String,
                                         x: Int
                                       ): List[String] = {
    topX(musicianName1, x):::topX(musicianName2, x) .filter(_.distinct != false)
  }
}
