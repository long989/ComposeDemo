package com.qkl.composedemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qkl.composedemo.bean.MessageBean
import com.qkl.composedemo.data.SampleData
import com.qkl.composedemo.ui.theme.ComposeDemoTheme

/**
 * @title:
 * @projectName NewDriverSchool
 * @description:
 * @author qiukailong
 * @date 2021/9/27
 */
class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Conversation(messages = SampleData.conversationSample)
                }
            }
        }
    }

    @Composable
    fun Conversation(messages: List<MessageBean>) {
        Column {
            Text(text = "点击",modifier = Modifier.padding(16.dp).clickable {
                testClosure(1)(2){
                    Log.e("qkl-it","$it")
                }
            })
            LazyColumn {
                items(messages) { message ->
                    MessageCard(message)
                }
            }
        }
    }

    @Composable
    fun MessageCard(msg: MessageBean) {
// Add padding around our message
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = null,
                modifier = Modifier
// Set image size to 40 dp
                    .size(40.dp)
// Clip image to be shaped as a circle
                    .clip(
                        CircleShape
                    )
                    .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
            )
// Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(8.dp))
// We keep track if message is expanded or not in this variable
            var isExpanded by remember { mutableStateOf(false) }

            // surfaceColor will be updated gradually from one color to the other
            val surfaceColor: Color by animateColorAsState(
                if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
            )

            // We toggle the isExpanded variable when we click on this Column
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = msg.title,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )

                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(4.dp))

                Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    // surfaceColor color will be changing gradually from primary to surface
                    color = surfaceColor,
                    // animateContentSize will change the Surface size gradually
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {
                    Text(
                        text = msg.content,
                        modifier = Modifier.padding(all = 4.dp),
                        // If the message is expanded, we display all its content otherwise we only display the first line
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }


    @Preview
    @Composable
    fun PreviewConversation() {
        ComposeDemoTheme {
            Conversation(SampleData.conversationSample)
        }
    }

    fun testClosure(v1: Int): (v2: Int, (Int) -> Unit) -> Unit {
        return fun(v2:Int,printer:(Int)->Unit){
           Log.e("qkl","v1+v2=${v1+v2}")
        }
    }
}