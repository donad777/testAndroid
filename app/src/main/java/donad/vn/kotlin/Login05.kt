package donad.vn.kotlin

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Login05() {

    var text by remember {
        mutableStateOf("")
    }

    data class product(val id: Int, val image: Int, var name: String)

    val list1 = remember {
        mutableStateListOf(
            product(1, R.drawable.potato, "Potato"),
            product(2, R.drawable.carot, "Carot"),
            product(3, R.drawable.onion, "Onion")
        )
    }
    val list2 = remember {
        mutableStateListOf(
            product(1, R.drawable.rice, "Rice"),
            product(2, R.drawable.pean, "Buckwheat"),
            product(3, R.drawable.rice2, "Cous Cous")
        )
    }
    val list3 = remember {
        mutableStateListOf(
            product(1, R.drawable.rug, "Rug"),
            product(2, R.drawable.crew, "Screwdriver"),
            product(3, R.drawable.towels, "Towels")
        )
    }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box {
                Text(text = "Your city")
            }
            Box {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height((20.dp))
                    )
                    Text(text = "Talin", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.scroll),
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height((20.dp))
                    )
                }
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .border(
                    width = 1.dp, // Độ dày của viền
                    color = Color.Black, // Màu viền
                    shape = RoundedCornerShape(16.dp) // Bo tròn viền
                )
                .clip(RoundedCornerShape(16.dp)) // Bo tròn cho Row
                .padding(5.dp), // Khoảng cách giữa nội dung và viền
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically // Canh giữa theo chiều dọc
        ) {
            Image(
                painter = painterResource(id = R.drawable.find),
                contentDescription = null,
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            )
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(text = "Search")},
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(16.dp)
                    ), // Background màu xám và bo góc
                shape = RoundedCornerShape(16.dp), // Bo góc 12dp,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White, // Màu nền cho TextField
                    textColor = Color.Black, // Màu chữ
                    focusedIndicatorColor = Color.Transparent, // Ẩn viền khi TextField được focus
                    unfocusedIndicatorColor = Color.Transparent // Ẩn viền khi TextField không được focus
                )
            )
        }
        Row(
            modifier = Modifier
                .padding(bottom = 8.dp, top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box {
                Text(
                    text = "Vegetables",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            Box {
                Image(
                    painter = painterResource(id = R.drawable.next),
                    contentDescription = null,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
        }
        LazyRow(modifier = Modifier) {
            items(list1) { item ->
                Card(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Text(
                            text = item.name,
                            modifier = Modifier.padding(top = 8.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Image(
                            painter = painterResource(id = item.image),
                            contentDescription = item.name,
                            modifier = Modifier
                                .width(100.dp)
                                .height(120.dp)
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(bottom = 8.dp, top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box {
                Text(
                    text = "Grocery",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Box {
                Image(
                    painter = painterResource(id = R.drawable.next),
                    contentDescription = null,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
        }
        LazyRow(modifier = Modifier) {
            items(list2) { item ->
                Card(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Text(
                            text = item.name,
                            modifier = Modifier.padding(top = 8.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Image(
                            painter = painterResource(id = item.image),
                            contentDescription = item.name,
                            modifier = Modifier
                                .width(100.dp)
                                .height(120.dp)
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .padding(bottom = 8.dp, top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box {
                Text(
                    text = "For home",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            Box {
                Image(
                    painter = painterResource(id = R.drawable.next),
                    contentDescription = null,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
        }
        LazyRow(modifier = Modifier) {
            items(list3) { item ->
                Card(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Text(
                            text = item.name,
                            modifier = Modifier.padding(top = 8.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Image(
                            painter = painterResource(id = item.image),
                            contentDescription = item.name,
                            modifier = Modifier
                                .width(100.dp)
                                .height(120.dp)
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .padding(bottom = 8.dp, top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box {
                Text(
                    text = "Vegetables", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            Box {
                Image(
                    painter = painterResource(id = R.drawable.next),
                    contentDescription = null,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
        }
        LazyRow(modifier = Modifier) {
            items(list1) { item ->
                Card(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Text(
                            text = item.name,
                            modifier = Modifier.padding(top = 8.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Image(
                            painter = painterResource(id = item.image),
                            contentDescription = item.name,
                            modifier = Modifier
                                .width(100.dp)
                                .height(120.dp)
                        )
                    }
                }
            }
        }
    }
}