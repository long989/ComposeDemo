package com.qkl.composedemo.data

import com.qkl.composedemo.bean.MessageBean

/**
 * @title:
 * @projectName NewDriverSchool
 * @description:
 * @author qiukailong
 * @date 2021/9/27
 */
object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        MessageBean(
            "Colleague",
            "Test...Test...Test..."
        ),
        MessageBean(
            "Colleague",
            "List of Android versions:\n" +
                    "Android KitKat (API 19)\n" +
                    "Android Lollipop (API 21)\n" +
                    "Android Marshmallow (API 23)\n" +
                    "Android Nougat (API 24)\n" +
                    "Android Oreo (API 26)\n" +
                    "Android Pie (API 28)\n" +
                    "Android 10 (API 29)\n" +
                    "Android 11 (API 30)\n" +
                    "Android 12 (API 31)\n"
        ),
        MessageBean(
            "Colleague",
            "I think Kotlin is my favorite programming language.\n" +
                    "It's so much fun!"
        ),
        MessageBean(
            "Colleague",
            "Searching for alternatives to XML layouts..."
        ),
        MessageBean(
            "Colleague",
            "Hey, take a look at Jetpack Compose, it's great!\n" +
                    "It's the Android's modern toolkit for building native UI." +
                    "It simplifies and accelerates UI development on Android." +
                    "Less code, powerful tools, and intuitive Kotlin APIs :)"
        ),
        MessageBean(
            "Colleague",
            "It's available from API 21+ :)"
        ),
        MessageBean(
            "Colleague",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        MessageBean(
            "Colleague",
            "Android Studio next version's name is Arctic Fox"
        ),
        MessageBean(
            "Colleague",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        MessageBean(
            "Colleague",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        MessageBean(
            "Colleague",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        MessageBean(
            "Colleague",
            "Previews are also interactive after enabling the experimental setting"
        ),
        MessageBean(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
    )
}