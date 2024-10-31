//package donad.vn.kotlin
//
//import android.widget.Toast
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//
//fun main(){
//    val context = LocalContext.current
//
//    var so1 by remember {
//        mutableStateOf(
//            Math.floor((Math.random() * 5) + 1).toInt().toString()
//        )
//    }
//    var so2 by remember {
//        mutableStateOf(
//            Math.floor((Math.random() * 5) + 1).toInt().toString()
//        )
//    }
//    var so3 by remember {
//        mutableStateOf(
//            Math.floor((Math.random() * 10) + 1).toInt().toString()
//        )
//    }
//
//    var dau by remember {
//        mutableStateOf(
//            listOf("+", "-", "*", "/").random()
//        )
//    }
//
//    fun result(ketqua: Boolean) {
//        val ketQuaThucTe = when (dau) {
//            "+" -> so1.toInt() + so2.toInt()
//            "-" -> so1.toInt() - so2.toInt()
//            "*" -> so1.toInt() * so2.toInt()
//            "/" -> if (so2.toInt() != 0) so1.toInt() / so2.toInt() else 0
//            else -> 0
//        }
//
//        if (ketqua) {
//            if (so3.toInt() == ketQuaThucTe) {
//                Toast.makeText(context, "Bạn đã chọn đúng", Toast.LENGTH_SHORT).show()
//                // Random lại các số và dấu
//                so1 = Math.floor((Math.random() * 5) + 1).toInt().toString()
//                so2 = Math.floor((Math.random() * 5) + 1).toInt().toString()
//                so3 = Math.floor((Math.random() * 10) + 1).toInt().toString()
//                dau = listOf("+", "-", "*", "/").random()
//            } else {
//                Toast.makeText(context, "Game over", Toast.LENGTH_SHORT).show()
//            }
//        } else {
//            if (so3.toInt() != ketQuaThucTe) {
//                Toast.makeText(context, "Bạn đã chọn đúng", Toast.LENGTH_SHORT).show()
//                // Random lại các số và dấu
//                so1 = Math.floor((Math.random() * 5) + 1).toInt().toString()
//                so2 = Math.floor((Math.random() * 5) + 1).toInt().toString()
//                so3 = Math.floor((Math.random() * 10) + 1).toInt().toString()
//                dau = listOf("+", "-", "*", "/").random()
//            } else {
//                Toast.makeText(context, "Game over", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    // UI của bạn
//    Column(
//        modifier = Modifier.padding(20.dp),
//    ) {
//        Text(text = so1)
//        Text(text = dau)
//        Text(text = so2)
//        Text(text = "=")
//        Text(text = so3)
//        Button(onClick = { result(true) }) {
//            Text(text = "Đúng")
//        }
//        Button(onClick = { result(false) }) {
//            Text(text = "Sai")
//        }
//    }
//}