package com.qkl.composedemo

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * @title:
 * @projectName NewDriverSchool
 * @description:
 * @author qiukailong
 * @date 2022/6/29
 */
@Composable
fun LazyList(names: List<String> = List(100) { "Item $it" }) {
    LazyColumn() {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    //如果您展开第 1 项内容，然后滚动到第 20 项内容，再返回到第 1 项内容，您会发现第 1 项内容已恢复为原始尺寸。如果需要，您可以使用 rememberSaveable 保存此数据，
//    var expanded by remember{ mutableStateOf(false) }
    var expanded by rememberSaveable { mutableStateOf(false) }
    //动画
//    val extraPadding by animateDpAsState(
//        if (expanded) 20.dp else 4.dp
//    )
    //类似弹簧的动画
    val extraPadding by animateDpAsState(
        if (expanded) 40.dp else 4.dp,
        animationSpec = spring(
            stiffness = Spring.StiffnessMedium,
            dampingRatio = Spring.DampingRatioMediumBouncy
        )
    )
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
       Column(Modifier.fillMaxHeight()
           .padding(vertical = extraPadding.coerceAtLeast(0.dp), horizontal = 8.dp)
           .clickable {
           expanded = !expanded
       }) {
           Text(
               text = name,
               Modifier
                   .fillMaxWidth()
//                   .padding(vertical = extraPadding, horizontal = 8.dp)
//                   .clickable {
//                       expanded = !expanded
//                   }
           )
           Text(text = "007", style = MaterialTheme.typography.h4.copy(
                fontWeight = FontWeight.ExtraBold
              )
           )
       }
    }

}