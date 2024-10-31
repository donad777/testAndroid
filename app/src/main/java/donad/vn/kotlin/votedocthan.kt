//package donad.vn.kotlin
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//
//var docthan by remember { mutableStateOf(0) }
//var dacochu by remember { mutableStateOf(0) }
//var lgbt by remember { mutableStateOf(0) }
//9
//val totalVotes = docthan + dacochu + lgbt
//
//// Tính phần trăm
//var ttdocthan = if (totalVotes > 0) (docthan * 100) / totalVotes else 0
//var ttdacochu = if (totalVotes > 0) (dacochu * 100) / totalVotes else 0
//var ttlgbt = if (totalVotes > 0) (lgbt * 100) / totalVotes else 0
//
//Column(modifier = Modifier.padding(10.dp)) {
//    Row {
//        Image(
//            painter = painterResource(id = R.drawable.nguoiaylaai),
//            contentDescription = "",
//            modifier = Modifier
//                .width(230.dp)
//                .height(200.dp)
//        )
//        Column(modifier = Modifier.padding(10.dp)) {
//            Text(text = "Độc thân: $ttdocthan%", modifier = Modifier.padding(20.dp))
//            Text(text = "Đã có chủ: $ttdacochu%", modifier = Modifier.padding(20.dp))
//            Text(text = "LGBT: $ttlgbt%", modifier = Modifier.padding(20.dp))
//        }
//    }
//    Button(
//        onClick = { docthan++ },
//        modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
//            containerColor = Color(0xFFA3b8d5b),
//            contentColor = Color.White
//        )
//    ) {
//        Text(text = "Độc thân")
//    }
//    Button(
//        onClick = { dacochu++ },
//        modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
//            containerColor = Color.Red,
//            contentColor = Color.White
//        )
//    ) {
//        Text(text = "Đã có chủ")
//    }
//    Button(
//        onClick = { lgbt++ },
//        modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
//            containerColor = Color(0xFFA854D1),
//            contentColor = Color.White
//        )
//    ) {
//        Text(text = "LGBT")
//    }
//}