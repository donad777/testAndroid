import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

//package donad.vn.kotlin
//
//import android.widget.Toast
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//
//data class NhanVien(val maNV: Int, val tenNV: String, val luongCB: Int);
//
//val listNV = remember {
//    mutableStateListOf(
//        NhanVien(1, "Nguyen Van a", 5000),
//        NhanVien(2, "Nguyen Van b", 7000),
//        NhanVien(3, "Nguyen Van c", 9000),
//        NhanVien(4, "Nguyen Van d", 10000),
//    )
//}
//
//val context = LocalContext.current
//
//
//var manv by remember {
//    mutableStateOf("")
//}
//var tennv by remember {
//    mutableStateOf("")
//}
//var luong by remember {
//    mutableStateOf("")
//}
//
//fun save() {
//    // Biến để kiểm tra xem nhân viên đã tồn tại hay chưa
//    var isUpdated = false
//
//    // Duyệt qua danh sách để tìm và cập nhật nhân viên nếu mã NV trùng khớp
//    for (i in listNV.indices) {
//        if (listNV[i].maNV == manv.toInt()) {
//            // Cập nhật thông tin nhân viên tại vị trí i
//            listNV[i] = NhanVien(manv.toInt(), tennv, luong.toInt())
//            isUpdated = true
//            Toast.makeText(context, "Đã cập nhật thông tin nhân viên", Toast.LENGTH_SHORT).show()
//            break // Thoát khỏi vòng lặp vì đã tìm thấy và cập nhật
//        }
//    }
//
//    // Nếu nhân viên chưa tồn tại, thêm mới
//    if (!isUpdated) {
//        listNV.add(NhanVien(manv.toInt(), tennv, luong.toInt()))
//        Toast.makeText(context, "Đã thêm nhân viên mới", Toast.LENGTH_SHORT).show()
//    }
//
//    // Reset lại các trường nhập liệu
//    manv = ""
//    tennv = ""
//    luong = ""
//}
//
//fun delete(maNV: Int) {
//    listNV.removeIf { it.maNV == maNV }
//    Toast.makeText(context, "Đã xóa nhân viên", Toast.LENGTH_SHORT).show()
//}
//
//Column {
//    OutlinedTextField(
//        value = manv,
//        onValueChange = { manv = it },
//        label = { Text(text = "Nhập mã nv") })
//    OutlinedTextField(
//        value = tennv,
//        onValueChange = { tennv = it },
//        label = { Text(text = "Nhập tên nv") })
//    OutlinedTextField(
//        value = luong,
//        onValueChange = { luong = it },
//        label = { Text(text = "Nhập lương") })
//    Button(onClick = { save() }) {
//        Text(text = "Save")
//    }
//
//    LazyColumn(modifier = Modifier.fillMaxSize()) {
//        items(listNV) { item ->
//            Card(modifier = Modifier
//                .padding(top = 10.dp, start = 10.dp, end = 10.dp)
//                .fillMaxWidth()
//                .clickable {
//                    Toast
//                        .makeText(context, "Tên" + item.tenNV, Toast.LENGTH_SHORT)
//                        .show()
//                }
//            ) {
//                Column(modifier = Modifier.padding(5.dp)) {
//                    Text(text = item.maNV.toString())
//                    Text(text = item.tenNV)
//                    Text(text = item.luongCB.toString())
//                    Row {
//                        Text(
//                            text = "Sửa",
//                            color = Color.Blue,
//                            modifier = Modifier
//                                .padding(10.dp)
//                                .clickable {
//                                    manv = item.maNV.toString()
//                                    tennv = item.tenNV
//                                    luong = item.luongCB.toString()
//                                }
//                        )
//                        Text(
//                            text = "Xóa",
//                            color = Color.Red,
//                            modifier = Modifier
//                                .padding(10.dp)
//                                .clickable {
//                                    delete(item.maNV)
//                                }
//                        )
//                    }
//                }
//            }
//        }
//    }
//}