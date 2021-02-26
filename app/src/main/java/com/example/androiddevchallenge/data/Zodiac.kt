/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import java.util.Locale

enum class Zodiac(
    val emoji: String,
    val chineseName: String,
    val year: Int
) {
    RAT("\uD83D\uDC00", "鼠", 1984),
    OX("\uD83D\uDC02", "牛", 1985),
    TIGER("\uD83D\uDC05 ", "虎", 1986),
    RABBIT("\uD83D\uDC07 ", "兔", 1987),
    DRAGON("\uD83D\uDC09", "龙", 1988),
    SNAKE("\uD83D\uDC0D", "蛇", 1989),
    HORSE("\uD83D\uDC0E ", "马", 1990),
    GOAT("\uD83D\uDC10", "羊", 1991),
    MONKEY("\uD83D\uDC12", "猴", 1992),
    ROOSTER("\uD83D\uDC13", "鸡", 1993),
    DOG("\uD83D\uDC15", "狗", 1994),
    PIG("\uD83D\uDC16 ", "猪", 1995);

    fun displayName() = name.toLowerCase(Locale.ROOT).capitalize(Locale.ROOT)
}

val ZODIAC_LIST = Zodiac.values()
