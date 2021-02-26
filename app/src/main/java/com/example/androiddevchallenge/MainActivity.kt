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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.ZODIAC_LIST
import com.example.androiddevchallenge.data.Zodiac
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "zodiacs") {
        composable("zodiacs") {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Which pet would you like to adopt?")
                        }
                    )
                }
            ) {
                ZodiacList(onClickZodiac = { navController.navigate("zodiac/${it.name}") })
            }
        }
        composable("zodiac/{zodiacName}") { backStackEntry ->
            val zodiac = Zodiac.valueOf(
                requireNotNull(backStackEntry.arguments?.getString("zodiacName"))
            )
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Details of ${zodiac.displayName()}")
                        },
                        actions = {
                            Button(onClick = { navController.navigate("zodiacs") }) {
                                Text(text = "Back")
                            }
                        }
                    )
                }
            ) {
                ZodiacDetail(zodiac)
            }
        }
    }
}

@Composable
fun ZodiacList(onClickZodiac: (Zodiac) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            items(ZODIAC_LIST) { zodiac ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Button(
                        onClick = { onClickZodiac(zodiac) },
                        shape = CircleShape
                    ) {
                        Text(
                            text = "${zodiac.emoji} ${zodiac.displayName()}",
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ZodiacDetail(zodiac: Zodiac) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = zodiac.chineseName,
            fontSize = 160.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Born in ${zodiac.year}",
            fontSize = 40.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Photo ${zodiac.emoji}",
            fontSize = 40.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
