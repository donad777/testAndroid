package donad.vn.kotlin.ASM

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import donad.vn.kotlin.R
import donad.vn.kotlin.ViewModelApp.ViewModelApp


@Composable
fun Prouduct(navController: NavController, _id: String, viewModel: ViewModelApp = viewModel()) {

    val productDetail by viewModel.productDetail


    var number by remember {
        mutableStateOf(1)
    }

    fun tang() {
        number += 1
    }

    fun giam() {
        if (number > 0) {
            number -= 1
        }
    }

    LaunchedEffect(_id) {
        viewModel.getProductDetail(_id)
    }

    fun back() {
        navController.navigate("Home")
    }

    fun addtocart() {
        navController.navigate("Cart")
    }

    productDetail?.let { product ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(455.dp)
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(455.dp)
                )
                Button(
                    onClick = { back() },
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(x = 16.dp, y = 33.dp) // Điều chỉnh vị trí nếu cần
                        .width(50.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White // Đặt màu nền của nút thành màu đen
                    ),
                    shape = RoundedCornerShape(5.dp) // Bo tròn 10dp
                ) {
                    Text(
                        text = "<",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )
                }
            }

            Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
                Text(
                    text = product.productName ,
                    modifier = Modifier.padding(top = 20.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$${product.price ?: "N/A"}",
                        color = Color.Black,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Button(
                            onClick = { tang() },
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFebebeb) // Đặt màu nền của nút thành màu đen
                            ),
                            shape = RoundedCornerShape(5.dp) // Bo tròn 10dp
                        ) {
                            Text(
                                text = "+",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                        Text(
                            text = "$number",
                            modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                            fontSize = 18.sp
                        )
                        Button(
                            onClick = { giam() },
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFebebeb) // Đặt màu nền của nút thành màu đen
                            ),
                            shape = RoundedCornerShape(5.dp), // Bo tròn 10dp,

                        ) {
                            Text(
                                text = "-",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(top = 11.dp, bottom = 15.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                    )
                    Text(
                        text = "4.5",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                    )
                    Text(text = "(50 reviews)", color = Color.Gray)
                }
                Text(
                    text = product.description
                )
            }
            Box(
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter) // Đặt Box nằm ở dưới cùng
                        .padding(bottom = 20.dp) // Thêm khoảng cách dưới nếu cần
                ) {
                    Row {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .width(50.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFebebeb) // Đặt màu nền của nút thành màu đen
                            ),
                            shape = RoundedCornerShape(5.dp) // Bo tròn 10dp
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.mark),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(40.dp)
                                    .height(40.dp)
                            )
                        }
                        Button(
                            onClick = { addtocart() },
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black // Đặt màu nền của nút thành màu đen
                            ),
                            shape = RoundedCornerShape(5.dp) // Bo tròn 10dp
                        ) {
                            Text(text = "Add to cart", color = Color.White, fontSize = 20.sp)
                        }
                    }
                }
            }
        }
    }
}