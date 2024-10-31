package donad.vn.kotlin.ASM

import android.content.Intent
import android.util.Patterns
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
import donad.vn.kotlin.Data.LoginRes
import donad.vn.kotlin.Data.UserLogin
import donad.vn.kotlin.R
import donad.vn.kotlin.ViewModelApp.ViewModelApp

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Login(navController: NavController, viewModel: ViewModelApp = viewModel()) {

    val context = LocalContext.current

    val login1 by viewModel.loginResponse

    fun register() {
        navController.navigate("Register")
    }

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    // Hàm kiểm tra và thực hiện đăng nhập
    fun login() {
        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(
                context,
                "Vui lòng điền đủ thông tin",
                Toast.LENGTH_SHORT
            ).show()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(
                context,
                "Email không hợp lệ",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val loginReq = UserLogin(email, password)
            viewModel.login(loginReq)
        }
    }

// Lắng nghe phản hồi API
    LaunchedEffect(login1) {
        login1?.let { loginRes ->
            if (loginRes.message == "Thanh Cong") {
                // Nếu đăng nhập thành công, chuyển sang trang Home
                navController.navigate("Home") {
                    Toast.makeText(context, loginRes.message, Toast.LENGTH_SHORT).show()
                }
            } else {
                // Nếu đăng nhập thất bại, hiển thị thông báo lỗi
                Toast.makeText(context, loginRes.message, Toast.LENGTH_SHORT).show()
            }
        }
    }



    Box(modifier = Modifier.fillMaxSize())
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 40.dp),
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
                text = "Hello !",
                color = Color.Gray,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "WELCOME BACK",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 60.dp)
            )

            Text(text = "Email")
            TextField(
                value = email, onValueChange = { email = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent, // Tắt màu nền
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp) // Đặt chiều rộng tối đa
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

            Text(
                text = "Forgot Password",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally), // Căn giữa
                fontSize = 18.sp,
                color = Color.Black,
            )
            Button(
                onClick = { login() },
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 40.dp)
                    .align(Alignment.CenterHorizontally) // Căn giữa
                    .width(280.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA000000),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(5.dp) // Bo tròn các góc của button với bán kính 5dp
            ) {
                Text(text = "LOGIN")
            }
            val context = LocalContext.current
            Text(
                text = "SIGN UP",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        register()
                    }, // Căn giữa
                fontSize = 18.sp,
                color = Color.Black,
            )
        }
    }
}