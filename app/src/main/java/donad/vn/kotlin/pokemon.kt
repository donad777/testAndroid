//package donad.vn.kotlin
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.material3.Card
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//
//// Đảm bảo rằng data class đã được khai báo chính xác
//data class items(val maItems: Int, val image: Int)
//
//// Danh sách các items với hình ảnh từ resources
//val listNV = remember {
//    mutableStateListOf(
//        items(1, R.drawable.do1),
//        items(2, R.drawable.do1),
//        items(3, R.drawable.ghost),
//        items(4, R.drawable.ghost),
//        items(5, R.drawable.rua),
//        items(6, R.drawable.rua),
//    )
//}
//
//val context = LocalContext.current
//
//var click1 by remember {
//    mutableStateOf(0)
//}
//var click2 by remember {
//    mutableStateOf(0)
//}
//var firstClickIndex by remember { mutableStateOf(0) }
//
//var count = 0
//
//var check = true
//
//Column {
//    // Sử dụng LazyVerticalGrid để hiển thị các items
//    LazyVerticalGrid(
//        columns = GridCells.Adaptive(minSize = 100.dp),
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        items(listNV.size) { index ->
//            val item = listNV[index]   // Truy cập phần tử tại index
//            Card(
//                modifier = Modifier
//                    .padding(top = 10.dp, start = 10.dp, end = 10.dp)
//                    .clickable {
//                        count++
//                        if (count == 1) {
//                            click1 = item.image
//                            firstClickIndex = index
//                        } else if (count == 2) {
//                            click2 = item.image
//
//                            if (click1 == click2 && firstClickIndex != index) {
//                                listNV[firstClickIndex] = listNV[firstClickIndex].copy(image = R.drawable.white)
//                                listNV[index] = listNV[index].copy(image = R.drawable.white)
//                                count = 0
//                            } else {
//                                count = 1 // Nếu không trùng, tiếp tục tính cho lần nhấn tiếp theo
//                                firstClickIndex = index
//                                click1 = item.image
//                            }
//                            count = 0
//                            click1 = 0
//                            click2 = 0
//                            firstClickIndex = 0
//                        }
//                    }
//            ) {
//                Column(modifier = Modifier.padding(5.dp)) {
//                    Image(
//                        painter = painterResource(id = item.image),
//                        contentDescription = "",
//                        modifier = Modifier
//                            .width(100.dp)
//                            .height(100.dp)
//                    )
//                }
//            }
//        }
//    }
//}