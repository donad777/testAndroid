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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login01(navController: NavController) {

    var phone by remember {
        mutableStateOf("")
    }

    fun click(){
        navController.navigate("Login02/$phone")
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
            text = "Authorization or registration",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 40.dp)
        )
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = {Text("Enter your PhoneNumber")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
        )

        Button(
            onClick = { click() }, modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF32bc0d),
                contentColor = Color.White
            )
        ) {
            Text(text = "Confirm Login")
        }
        Text(text = "By clicking on the Confirm Login button, I agree to the terms of the use of the service",Modifier.padding(30.dp))
    }
}


