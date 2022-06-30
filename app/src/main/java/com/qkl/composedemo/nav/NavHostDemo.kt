package com.qkl.composedemo.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qkl.composedemo.page.PageOne
import com.qkl.composedemo.page.PageTwo
import com.qkl.composedemo.config.RouteConfig

/**
 * @title:
 * @projectName NewDriverSchool
 * @description:
 * @author qiukailong
 * @date 2022/6/30
 */
@Composable
fun NavHostDemo() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = RouteConfig.ROUTE_PAGEONE){
        composable(RouteConfig.ROUTE_PAGEONE) {
            PageOne(navController)
        }
        composable(RouteConfig.ROUTE_PAGETWO) {
            PageTwo(navController)
        }
    }
}