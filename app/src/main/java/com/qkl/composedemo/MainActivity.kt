package com.qkl.composedemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qkl.composedemo.bean.MessageBean
import com.qkl.composedemo.nav.NavHostDemo
import com.qkl.composedemo.page.LayoutInCompose
import com.qkl.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    Greeting(MessageBean("title", "content"))
//                    test1(MessageBean("title", "content"))
                    //状态变更
//                    test()
                    //列表动画
//                    LazyList()
                    //页面切换，传递参数
//                    NavHostDemo()
                    //toolbar和bottomBar
                    LayoutInCompose()
                }
            }
        }
    }
}

@Composable
fun test() {
    var showTest by remember { mutableStateOf(true) }
    if (showTest) {
        test1(MessageBean("title", "content"), onContinueClicked = {
            showTest = false
        })
    } else {
        Greeting(MessageBean("title", "content"), onContinueClicked = {
            showTest = true
        })
    }
}

@Composable
fun test1(msg: MessageBean, onContinueClicked: () -> Unit) {
    val context = LocalContext.current
    val firstPicClickable = remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = msg.title,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
            Text(
                text = msg.content,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "这是第一个图片",
                Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .clickable {
                        firstPicClickable.value = !firstPicClickable.value
                        Toast
                            .makeText(context, "点击了第一张图片", Toast.LENGTH_SHORT)
                            .show()
                    },
            )
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "这是第二个图片",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(50.dp)
                    .clip(shape = if (firstPicClickable.value) RoundedCornerShape(6.dp) else CircleShape)
                    .clickable {
                        Toast
                            .makeText(context, "点击了第二张图片", Toast.LENGTH_SHORT)
                            .show()
                    },
            )
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "这是第三个个图片",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(50.dp)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(6.dp))
                    .clip(shape = RoundedCornerShape(6.dp))
                    .clickable {
                        onContinueClicked()
                        Toast
                            .makeText(context, "点击了第三张图片", Toast.LENGTH_SHORT)
                            .show()
                    },
            )
        }
        Text(
            text = msg.title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = msg.content,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun Greeting(msg: MessageBean, onContinueClicked: () -> Unit) {
    Row(modifier = Modifier.padding(all = 10.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "这是测试的一张图片",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .clickable {
                    onContinueClicked()
                },
        )
        Spacer(modifier = Modifier.width(width = 10.dp))
        Column() {
            Text(
                text = "这是 ${msg.title}!", textAlign = TextAlign.Right,
                color = MaterialTheme.colors.error,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .border(width = 1.dp, color = Color.Blue),
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(height = 10.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 10.dp) {
                Text(text = "这是 ${msg.content}!", modifier = Modifier.padding(all = 10.dp))
            }

        }
    }
}

/**
 *
@Preview(name = "Light Mode")
@Preview(
uiMode = Configuration.UI_MODE_NIGHT_YES,
showBackground = true,
name = "Dark Mode"
)
 */
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDemoTheme {
        test1(MessageBean("title", "content"), onContinueClicked = {
        })
    }
}