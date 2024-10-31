package donad.vn.kotlin.test

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
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
fun LoginTest(navController:NavController) {

    val context = LocalContext.current
    var phone by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    fun click() {
        if (phone == "" || password == "") {
            Toast.makeText(
                context,
                "Vui lòng điền đủ thông tin",
                Toast.LENGTH_SHORT
            ).show()
        }else if (password.length < 8){
            Toast.makeText(
                context,
                "Vui lòng nhập mật khẩu hơn 8 kí tự",
                Toast.LENGTH_SHORT
            ).show()
        }else{
        navController.navigate("HomeTest")
        }
    }

    Column(modifier = Modifier.padding(20.dp)) {
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = null,
            modifier = Modifier.size(width = 20.dp, height = 20.dp)
        )
        Text(
            text = "Welcome back to",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 60.dp)
        )
        Text(text = "Mega Mall", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Text(
            text = "Silahkan masukan data untunk login",
            color = Color.Gray,
            modifier = Modifier.padding(top = 30.dp, bottom = 30.dp)
        )
        Text(text = "Email/Phone", modifier = Modifier.padding(bottom = 20.dp))
        TextField(
            value = phone,
            onValueChange = { newvalue -> phone = newvalue.uppercase() },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFebebeb),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(5.dp)
        )
        Text(text = "Password", modifier = Modifier.padding(top = 40.dp, bottom = 20.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFebebeb),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(5.dp),
            visualTransformation = if (isFocused) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            interactionSource = interactionSource
        )
        Button(
            onClick = { click() }, modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF03a9f4),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(5.dp) // Bo tròn các góc của button với bán kính 5dp
        ) {
            Text(text = "Sign In")
        }
        Row(
            modifier = Modifier
                .padding(top = 150.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Forgot Password", color = Color.Black)
            Text(text = "Sign Up", color = Color.Blue)
        }

    }
}
