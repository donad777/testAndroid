import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import donad.vn.kotlin.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Hi(navController: NavController) {
    fun click() {
        navController.navigate("Login")
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Để ảnh phủ đầy màn hình
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Make your",
                color = Color.Gray,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Home beautiful",
                color = Color.Black,
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "The  best  simple  place  where  you  discover  most  wonderful  furnitures  and  make  your  home  beautiful",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 50.dp, bottom = 120.dp),// Căn giữa
                color = Color.Gray,
                fontSize = 18.sp,
                letterSpacing = 2.sp, // Tạo khoảng cách giữa các chữ
            )
            val context = LocalContext.current
            Button(
                onClick = { click() },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(160.dp)
                    .height(50.dp), // Căn giữa
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA000000),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(5.dp) // Bo tròn các góc của button với bán kính 5dp
            ) {
                Text(text = "Get started")
            }
        }
    }
}