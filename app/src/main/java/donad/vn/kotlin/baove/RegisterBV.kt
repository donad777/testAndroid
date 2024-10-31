package donad.vn.kotlin.test

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import donad.vn.kotlin.R
import okhttp3.internal.wait
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterBV(navController: NavController) {

    val context = LocalContext.current
    var firstName by remember {
        mutableStateOf("")
    }
    var lastName by remember {
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



    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    fun click() {
        if (email == "" || password == "" || repass == "" || firstName == "" || lastName == "") {
            Toast.makeText(
                context, "Vui lòng điền đủ thông tin", Toast.LENGTH_SHORT
            ).show()
        } else if (password.length < 8) {
            Toast.makeText(
                context,
                "Vui lòng nhập mật khẩu nhiều hơn 8 kí tự",
                Toast.LENGTH_SHORT
            ).show()
        } else if (password != repass) {
            Toast.makeText(
                context, "Vui lòng nhập mật khẩu trùng nhau", Toast.LENGTH_SHORT
            ).show()
        } else {
            navController.navigate("HomeBV")
        }
    }

    Column(
        modifier = Modifier.background(Color(0xFF009688))
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 20.dp, height = 20.dp)
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome to tradly",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(top = 20.dp),
                    color = Color.White
                )
                Text(
                    text = "Signup to your account",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 40.dp)
                )
            }
            TextField(
                value = firstName,
                onValueChange = { firstName = it },
                placeholder = { Text(text = "First name") },
                modifier = Modifier.padding(top = 25.dp).fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(5.dp)
            )
            TextField(
                value = lastName,
                onValueChange = { lastName = it },
                placeholder = { Text(text = "Last name") },
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(5.dp)
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(text = "Email ID/Phone Number") },
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(5.dp)
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = "Password") },
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(5.dp),
                visualTransformation = if (isFocused) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                interactionSource = interactionSource
            )

            TextField(
                value = repass,
                onValueChange = { repass = it },
                placeholder = { Text(text = "Re-enter Password") },
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(5.dp),
                visualTransformation = if (isFocused) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                interactionSource = interactionSource
            )


            Button(
                onClick = { click() },
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White, contentColor = Color(0xFF009688)
                ),
                shape = RoundedCornerShape(5.dp) // Bo tròn các góc của button với bán kính 5dp
            ) {
                Text(text = "Sign Up")
            }
            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                Arrangement.Center,
                Alignment.CenterVertically
            ) {
                Text(text = "have an account?", color = Color.White)
                Text(text = "Sign Up", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}
