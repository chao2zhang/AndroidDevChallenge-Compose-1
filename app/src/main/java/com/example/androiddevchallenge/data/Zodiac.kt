package com.example.androiddevchallenge.data

data class Zodiac(
    val name: String,
    val emoji: String,
    val chineseName: String,
    val year: Int
)

val RAT = Zodiac("Rat", "\uD83D\uDC2D", "鼠", 1984)
val OX = Zodiac("Ox", "\uD83D\uDC2D", "牛", 1984)
val TIGER = Zodiac("Tiger", "\uD83D\uDC2D", "虎", 1984)
val RABBIT = Zodiac("Rabbit", "\uD83D\uDC2D", "兔", 1984)

val ZODIAC_LIST = listOf(RAT, OX, TIGER, RABBIT)