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
import com.qkl.composedemo.config.RouteConfig
import com.qkl.composedemo.ui.theme.ComposeDemoTheme

/**
 * @title:
 * @projectName NewDriverSchool
 * @description:
 * @author qiukailong
 * @date 2022/6/30
 */
@Composable
fun PageOne(navController: NavController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = "这是第一个页面",
            modifier = Modifier.fillMaxWidth(),
            color = Color.Blue,
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 16.sp)
        )
        Button(onClick = {
            Toast.makeText(context, "跳转到第二个页面", Toast.LENGTH_LONG).show()
            navController.navigate(RouteConfig.ROUTE_PAGETWO)
        }, modifier = Modifier.fillMaxWidth()) {
            Text("点击跳转到第二个页面")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeDemoTheme {
//        PageOne()
    }
}