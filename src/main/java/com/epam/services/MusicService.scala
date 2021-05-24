package com.epam.services

/**
 * @author Evgeny Borisov
 */
trait MusicService {

  def topXWithRate(musicianName: String, x: Int): Map[String, Int]

  def topX(musicianName: String, x: Int): List[String]

  def compareBetweenTwoArtists(musicianName1: String, musicianName2: String, x: Int): List[String]
}
