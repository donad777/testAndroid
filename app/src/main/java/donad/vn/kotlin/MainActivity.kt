package donad.vn.kotlin

import Hi
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import donad.vn.kotlin.ASM.Cart
import donad.vn.kotlin.ASM.Congrats
import donad.vn.kotlin.ASM.Home
import donad.vn.kotlin.ASM.Login
import donad.vn.kotlin.ASM.Pay
import donad.vn.kotlin.ASM.Prouduct
import donad.vn.kotlin.ASM.Register
import donad.vn.kotlin.test.HomeBV
import donad.vn.kotlin.test.HomeTest
import donad.vn.kotlin.test.LoginTest
import donad.vn.kotlin.test.RegisterBV
import donad.vn.kotlin.test.RegisterTest
import donad.vn.kotlin.ui.theme.KotlinTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Test()
                }
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun Test() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "RegisterBV") {
            composable("Login01") { Login01(navController) }
            composable(
                "Login02/{phonenumber}",
                arguments = listOf(navArgument("phonenumber") { type = NavType.StringType })
            ) { NavBackStackEntry ->
                Login02(
                    navController,
                    phonenumber = NavBackStackEntry.arguments?.getString("phonenumber")
                )
            }
            composable("Login03") { Login03(navController) }
            composable("Login04") { Login04(navController) }
            composable("Login05") { Login05() }
            //bao ve
            composable("RegisterBV") { RegisterBV(navController) }
            composable("HomeBV") { HomeBV() }
            //test
            composable("LoginTest") { LoginTest(navController) }
            composable("HomeTest") { HomeTest() }
            composable("RegisterTest") { RegisterTest(navController) }
            //asm
            composable("Home") { Home(navController) }
            composable("Cart") { Cart(navController) }
            composable("Pay") { Pay(navController) }
            composable("Congrats") { Congrats(navController) }
            composable("Login") { Login(navController) }
            composable("Register") { Register(navController) }
            composable(
                "Product/{_id}",
                arguments = listOf(
                    navArgument("_id") { type = NavType.StringType },
                ),
            ) { navBackStackEntry ->
                Prouduct(
                    navController = navController,
                    _id = navBackStackEntry.arguments?.getString("_id").toString()
                )
            }

            composable("Hi") { Hi(navController) }
        }
    }
}


