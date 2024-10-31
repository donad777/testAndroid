package donad.vn.kotlin.ASM

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import donad.vn.kotlin.R
import donad.vn.kotlin.ViewModelApp.ViewModelApp

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Home(navController: NavController, viewModel: ViewModelApp = viewModel()) {

    val productall by viewModel.products

    val cateall by viewModel.categories

    val context = LocalContext.current

    var selectedCategoryId by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        viewModel.getProductViewModel()
    }

    LaunchedEffect(Unit) {
        viewModel.getCate()
    }

    val filteredProducts = if (selectedCategoryId != null) {
        //it.category lấy id của category từ model product
        productall.filter { it.category == selectedCategoryId }
    } else {
        productall
    }


    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.find),
                    contentDescription = null,
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                )
            }
            Box(modifier = Modifier) {
                Column {
                    Text(
                        text = "Make home", fontSize = 25.sp, color = Color.LightGray
                    )
                    Text(
                        text = "BEAUTIFUL",
                        fontSize = 25.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            Box(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = null,
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                )
            }
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(cateall) { item ->
                Column(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp, end = 15.dp)
                        .clickable {
                            Toast
                                .makeText(
                                    context,
                                    "${item._id}",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                            selectedCategoryId = item._id
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .width(44.dp)
                            .height(44.dp)
                            .clip(RoundedCornerShape(10.dp)) // Bo góc cho Box
                            .background(Color.LightGray) // Màu nền của Box
                            .padding(8.dp), // Padding bên trong Box để tạo khoảng cách giữa các thành phần và viền
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = item.image,
                            contentDescription = null,
                            modifier = Modifier
                                .width(44.dp)
                                .height(44.dp)
                        )
                    }
                    Text(text = item.cateName, fontSize = 14.sp, color = Color.LightGray)
                }
            }
        }
        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(10.dp)) {
            items(filteredProducts) { item ->
                Column(modifier = Modifier.clickable {
                    navController.navigate("Product/${item._id}")
                    Toast.makeText(
                        context,
                        "${item._id}",
                        Toast.LENGTH_SHORT
                    ).show()
                }) {
                    AsyncImage(
                        model = item.image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop, // Đảm bảo ảnh lấp đầy và cắt theo kích thước
                        modifier = Modifier
                            .height(200.dp)
                            .width(157.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Text(
                        text = item.productName,
                        modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                        fontSize = 14.sp
                    )
                    Text(
                        text = "$" + item.price.toString(),
                        modifier = Modifier.padding(bottom = 15.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}