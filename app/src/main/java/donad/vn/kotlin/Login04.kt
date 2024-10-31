package donad.vn.kotlin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login04(navController: NavController) {
    fun click() {
        navController.navigate("Login05")
    }

    Column(modifier = Modifier.padding(20.dp)) {
        Text(
            text = "Delivery Of",
            color = Color(0xFF32bc0d),
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "products",
            color = Color(0xFF32bc0d),
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 70.dp)
        )
        Text(
            text = "Let's get acquainted!",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 40.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { "" },
            label = { Text( "Enter your Name" ) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
        )
        OutlinedTextField(
            value = "",
            onValueChange = { "" },
            label = {Text( "Enter your Birth" )},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
        )

        Button(
            onClick = { click() }, modifier = Modifier
                .padding(bottom = 190.dp)
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF32bc0d),
                contentColor = Color.White
            )
        ) {
            Text(text = "Continue")
        }
        Text(
            text = "Skip this step",
            color = Color(0xFF32bc0d),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}