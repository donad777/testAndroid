package donad.vn.kotlin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login02(navController: NavController, phonenumber: String?) {

    fun click() {
        navController.navigate("Login03")
    }

    var pin1 by remember { mutableStateOf("") }
    var pin2 by remember { mutableStateOf("") }
    var pin3 by remember { mutableStateOf("") }
    var pin4 by remember { mutableStateOf("") }

    val focusRequester1 = remember { FocusRequester() }
    val focusRequester2 = remember { FocusRequester() }
    val focusRequester3 = remember { FocusRequester() }
    val focusRequester4 = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

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
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp)
        )
        Text(
            text = "We have sent a message to ",
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Color.Gray
        )
        Text(
            text = "phone +$phonenumber ",
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Color.Gray
        )
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp)
        ) {
            OutlinedTextField(
                value = pin1,
                onValueChange = {
                    if (it.length <= 1) {
                        pin1 = it
                        if (it.isNotEmpty()) focusRequester2.requestFocus() // Chuyển đến ô tiếp theo
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .padding(5.dp)
                    .height(60.dp)
                    .width(60.dp)
                    .focusRequester(focusRequester1)
            )
            OutlinedTextField(
                value = pin2,
                onValueChange = {
                    if (it.length <= 1) {
                        pin2 = it
                        if (it.isNotEmpty()) focusRequester3.requestFocus()
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .padding(5.dp)
                    .height(60.dp)
                    .width(60.dp)
                    .focusRequester(focusRequester2)
            )
            OutlinedTextField(
                value = pin3,
                onValueChange = {
                    if (it.length <= 1) {
                        pin3 = it
                        if (it.isNotEmpty()) focusRequester4.requestFocus()
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .padding(5.dp)
                    .height(60.dp)
                    .width(60.dp)
                    .focusRequester(focusRequester3)
            )
            OutlinedTextField(
                value = pin4,
                onValueChange = {
                    if (it.length <= 1) {
                        pin4 = it
                        if (it.isNotEmpty()) focusManager.clearFocus() // Dừng focus sau ô cuối cùng
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .padding(5.dp)
                    .height(60.dp)
                    .width(60.dp)
                    .focusRequester(focusRequester4)
            )
        }

        Button(
            onClick = { click() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF32bc0d), contentColor = Color.White
            )
        ) {
            Text(text = "Confirm Login")
        }
        Text(
            text = "By clicking on the Confirm Login button, I agree to the terms of the use of the service",
            Modifier.padding(30.dp)
        )
    }
}