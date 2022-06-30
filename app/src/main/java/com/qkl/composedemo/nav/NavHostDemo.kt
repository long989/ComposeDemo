package com.qkl.composedemo.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.qkl.composedemo.config.ParamsConfig
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
    NavHost(navController = navController, startDestination = RouteConfig.ROUTE_PAGEONE) {
        composable(RouteConfig.ROUTE_PAGEONE) {
            PageOne(navController)
        }
        composable(
            "${RouteConfig.ROUTE_PAGETWO}/{${ParamsConfig.PARAMS_NAME}}?${ParamsConfig.PARAMS_AGE}={${ParamsConfig.PARAMS_AGE}}",
            arguments = listOf(
                navArgument(ParamsConfig.PARAMS_AGE) {
                    defaultValue = 18
                    type = NavType.IntType },
            )
        ) {
            val arguments = requireNotNull(it.arguments)
           val name = arguments.getString(ParamsConfig.PARAMS_NAME)!!
           val age = arguments.getInt(ParamsConfig.PARAMS_AGE)
            PageTwo(navController,name,age)
        }
    }
}