////package donad.vn.kotlin
////
////
//val context = LocalContext.current
//
//var so1 by remember {
//    mutableStateOf(
//        Math.floor((Math.random() * 5) + 1).toInt().toString()
//    )
//}
//var so2 by remember {
//    mutableStateOf(
//        Math.floor((Math.random() * 5) + 1).toInt().toString()
//    )
//}
//var dau by remember {
//    mutableStateOf(
//        listOf("+", "-", "*").random()
//    )
//}
//
//// Hàm tính toán kết quả thực tế
//fun calculateResult(num1: Int, num2: Int, operator: String): Int {
//    return when (operator) {
//        "+" -> num1 + num2
//        "-" -> num1 - num2
//        "*" -> num1 * num2
////                "/" -> if (num2 != 0) num1 / num2 else 0
//        else -> 0
//    }
//}
//
//var so3 by remember {
//    mutableStateOf(
//        calculateResult(so1.toInt(), so2.toInt(), dau).toString()
//    )
//}
//
//// Chọn ngẫu nhiên phần tử sẽ bị ẩn (so1, so2, hoặc so3)
//var visibleElement by remember {
//    mutableStateOf(
//        listOf("so1", "dau" ,"so2", "so3").random()
//    )
//}
//
//// Biến để lưu kết quả nhập từ người dùng
//var userInput by remember { mutableStateOf("") }
//
//
//// Hàm random lại các giá trị
//fun randomizeValues() {
//    so1 = Math.floor((Math.random() * 5) + 1).toInt().toString()
//    so2 = Math.floor((Math.random() * 5) + 1).toInt().toString()
//    dau = listOf("+", "-", "*").random()
//    so3 = calculateResult(so1.toInt(), so2.toInt(), dau).toString()
//    visibleElement = listOf("so1", "so2", "so3").random()
//    userInput = "" // Reset lại input của người dùng
//}
//
//fun checkResult() {
////            val ketQuaThucTe = calculateResult(so1.toInt(), so2.toInt(), dau)
//
//    val isCorrect = when (visibleElement) {
//        "so1" -> userInput == so1
//        "so2" -> userInput == so2
//        "so3" -> userInput == so3
//        "dau" -> userInput == dau
//        else -> false
//    }
//
//    if (isCorrect) {
//        Toast.makeText(context, "Bạn đã chọn đúng", Toast.LENGTH_SHORT).show()
//        randomizeValues()
//    } else {
//        Toast.makeText(context, "Game over", Toast.LENGTH_SHORT).show()
//        randomizeValues()
//    }
//}
//
//
//// UI
//Column(
//modifier = Modifier
//.padding(20.dp)
//.fillMaxSize(),
//verticalArrangement = Arrangement.Center,
//horizontalAlignment = Alignment.CenterHorizontally
//) {
//    if (visibleElement != "so1") {
//        Text(text = so1)
//    } else {
//        TextField(
//            value = userInput,
//            onValueChange = { userInput = it },
//            label = { Text(text = "Điền số 1") },
//            singleLine = true,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )
//    }
//
////            Text(text = dau)
//    if (visibleElement != "dau") {
//        Text(text = dau)
//    } else {
//        TextField(
//            value = userInput,
//            onValueChange = { userInput = it },
//            label = { Text(text = "Điền dấu") },
//            singleLine = true,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )
//    }
//
//    if (visibleElement != "so2") {
//        Text(text = so2)
//    } else {
//        TextField(
//            value = userInput,
//            onValueChange = { userInput = it },
//            label = { Text(text = "Điền số 2") },
//            singleLine = true,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )
//    }
//
//    Text(text = "=")
//
//
//    if (visibleElement != "so3") {
//        Text(text = so3)
//    } else {
//        TextField(
//            value = userInput,
//            onValueChange = { userInput = it },
//            label = { Text(text = "Điền kết quả") },
//            singleLine = true,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
//        )
//    }
//
//    Spacer(modifier = Modifier.height(16.dp))
//
//    Button(onClick = { checkResult() }) {
//        Text(text = "Kiểm tra kết quả")
//    }
//}