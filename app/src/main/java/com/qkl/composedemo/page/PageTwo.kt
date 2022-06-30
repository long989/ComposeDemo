package com.qkl.composedemo.page

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.qkl.composedemo.ui.theme.ComposeDemoTheme

/**
 * @title:
 * @projectName NewDriverSchool
 * @description:
 * @author qiukailong
 * @date 2022/6/30
 */
@Composable
fun PageTwo(navController: NavController,name:String,age:Int) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = "他叫$name,今年$age 岁了",
            modifier = Modifier.fillMaxWidth(),
            color = Color.Blue,
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 16.sp)
        )
        Button(onClick = {
            Toast.makeText(context, "返回到第一个页面", Toast.LENGTH_LONG).show()
            navController.popBackStack()
        }, modifier = Modifier.fillMaxWidth()) {
            Text("返回到第一个页面")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeDemoTheme {
        PageTwo(rememberNavController(),"李白",18)
    }
}