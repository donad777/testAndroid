package donad.vn.kotlin.test

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import coil.compose.AsyncImage
import donad.vn.kotlin.R
import okhttp3.internal.wait
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeTest() {

    val context = LocalContext.current
    var search by remember {
        mutableStateOf("")
    }

    data class Product(val id: Int, val nameProduct: String, val image: String, val price: Int)

    val list1 = remember {
        mutableStateListOf(
            Product(
                1,
                "Product D",
                "https://img.freepik.com/free-photo/3d-cartoon-beauty-products_23-2151503319.jpg",
                12000
            ),
            Product(
                2,
                "Product D",
                "https://img.freepik.com/free-photo/3d-cartoon-beauty-products_23-2151503319.jpg",
                12000
            ),
            Product(
                3,
                "Product D",
                "https://img.freepik.com/free-photo/3d-cartoon-beauty-products_23-2151503319.jpg",
                12000
            ),
            Product(
                4,
                "Product D",
                "https://img.freepik.com/free-photo/3d-cartoon-beauty-products_23-2151503319.jpg",
                12000
            ),
            Product(
                5,
                "Product D",
                "https://img.freepik.com/free-photo/3d-cartoon-beauty-products_23-2151503319.jpg",
                12000
            ),
            Product(
                6,
                "Product D",
                "https://img.freepik.com/free-photo/3d-cartoon-beauty-products_23-2151503319.jpg",
                12000
            ),
        )
    }

    Column(modifier = Modifier.padding(20.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier.size(width = 20.dp, height = 20.dp)
            )
            Text(text = "Category", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Image(
                painter = painterResource(id = R.drawable.cart),
                contentDescription = null,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp),
            )
        }
        // Đường kẻ ngang
        Divider(
            color = Color.Gray, // Màu xám
            thickness = 0.5.dp,   // Độ dày của đường
        )

        Text(
            text = "Gadget",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 30.dp, bottom = 30.dp)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = search,
                onValueChange = { search = it },
                placeholder = { "Search Product Name" },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFebebeb),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(10.dp)
            )
        }

        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(10.dp)) {
            items(list1) { item ->
                Column (){
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
                        text = item.nameProduct,
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
