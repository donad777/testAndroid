package donad.vn.kotlin.ASM

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import donad.vn.kotlin.R
import donad.vn.kotlin.ViewModelApp.ViewModelApp


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Register(navController: NavController, viewModel: ViewModelApp = viewModel()) {

    val context = LocalContext.current

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    fun login() {
        navController.navigate("Login")
    }

    var userName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    var repass by remember {
        mutableStateOf("")
    }

    fun signUp() {
        if (userName == "" || email == "" || password == "" || repass == "") {
            Toast.makeText(
                context,
                "Vui lòng điền đủ thông tin",
                Toast.LENGTH_SHORT
            ).show()
        }else if (repass == password) {
            viewModel.registerUser(email, userName, password)
            Toast.makeText(
                context,
                "Đăng kí thành công",
                Toast.LENGTH_SHORT
            ).show()
            navController.navigate("Login")
        }else{
            Toast.makeText(
                context,
                "Vui lòng nhập trùng password",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 30.dp),
                verticalAlignment = Alignment.CenterVertically, // Căn giữa các hình ảnh theo chiều dọc
            ) {
                Image(
                    painter = painterResource(id = R.drawable.line),
                    contentDescription = null,
                    Modifier
                        .width(100.dp)
                        .height(30.dp)
                )
                Spacer(modifier = Modifier.width(10.dp)) // Tạo khoảng cách giữa các hình ảnh
                Image(
                    painter = painterResource(id = R.drawable.group),
                    contentDescription = null,
                    Modifier
                        .width(60.dp)
                        .height(60.dp)
                )
                Spacer(modifier = Modifier.width(10.dp)) // Tạo khoảng cách giữa các hình ảnh
                Image(
                    painter = painterResource(id = R.drawable.line),
                    contentDescription = null,
                    Modifier
                        .width(100.dp)
                        .height(30.dp)
                )
            }

            Text(
                text = "WELCOME",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Text(text = "Name")
            TextField(
                value = userName, onValueChange = { userName = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent, // Tắt màu nền
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp) // Đặt chiều rộng tối đa
            )

            Text(text = "Email")
            TextField(
                value = email, onValueChange = { email = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent, // Tắt màu nền
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp) // Đặt chiều rộng tối đa
            )
            Text(text = "Password")
            TextField(
                value = password, onValueChange = { password = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent, // Tắt màu nền
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp), // Đặt chiều rộng tối đa
                visualTransformation = if (isFocused) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                interactionSource = interactionSource
            )

            Text(text = "Confirm Password")
            TextField(
                value = repass, onValueChange = { repass = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent, // Tắt màu nền
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp), // Đặt chiều rộng tối đa
                visualTransformation = if (isFocused) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                interactionSource = interactionSource
            )
            Button(
                onClick = { signUp() },
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp)
                    .align(Alignment.CenterHorizontally) // Căn giữa
                    .width(280.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA000000),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(5.dp) // Bo tròn các góc của button với bán kính 5dp
            ) {
                Text(text = "SIGN UP")
            }

            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Already have account? ",
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 3.dp)
                )
                Text(
                    text = "SIGN IN",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { login() }
                )
            }
        }
    }
}