package donad.vn.kotlin

fun main() {
    var choose = true
    while (choose) {
        println("**********************************************************************************")
        println("* 1. Nhập n, kiểm tra số đó có phải là số hoàn thiện hay không?                  *")
        println("* 2. Nhập n => tạo ta chuỗi fibonacci từ 1 đến n                                 *")
        println("* 3. Nhập một số bất kỳ, kiểm tra xem số đó có phải là số đối xứng hay không?    *")
        println("* 4.  Nhập 2 số a và b bất kỳ, kiểm tra xem số b có chứa trong số a hay không?   *")
        println("**********************************************************************************")
        print("Vui lòng chọn câu (1/2/3/4): ")
        var bai = readln().toInt()
        when (bai) {
            1 -> {
                bai11()
                print("Bạn có muốn chọn tiếp ? (y/n): ")
                var countinue = readln()
                if (countinue.equals("n") || countinue.equals("N")) {
                    choose = false
                }
            }

            2 -> {
                bai12()
                print("Bạn có muốn chọn tiếp ? (y/n): ")
                var countinue = readln()
                if (countinue.equals("n") || countinue.equals("N")) {
                    choose = false
                }
            }

            3 -> {
                bai13()
                print("Bạn có muốn chọn tiếp ? (y/n): ")
                var countinue = readln()
                if (countinue.equals("n") || countinue.equals("N")) {
                    choose = false
                }
            }

            4 -> {
                bai14()
                print("Bạn có muốn chọn tiếp ? (y/n): ")
                var countinue = readln()
                if (countinue.equals("n") || countinue.equals("N")) {
                    choose = false
                }
            }

            else -> {
                println("Vui lòng chọn đúng bài!")
            }
        }
    }
}

fun bai11() {
    print("Vui long nhap so n: ")
    var n = readln().toInt()
    var temp = 0
    for (i in 1 until n) {
        if (n % i == 0) {
            temp += i
        }
    }
    if (n == temp) {
        println("n là số hoàn thiện")
    } else {
        println("Không phải là số hoàn thiện")
    }

}

fun bai12() {
    print("Vui lòng nhập số n: ")
    var n = readln().toInt()
    var temp1 = 0
    var temp2 = 1
    var sum = 0
    print("$temp1$temp2")
    while (true) {
        sum = temp1 + temp2
        if (sum > n) {
            break
        }
        print("$sum")
        temp1 = temp2
        temp2 = sum
    }
    println()
}

fun bai13() {
    print("Vui lòng nhập số n: ")
    var n = readln().toInt()

    val n1 = n
    var temp = 0

    while (n != 0) {
        val digit = n % 10
        if(digit == 0){
            break;
            println("$n1 Không phải là số đối xứng")
        }
        temp = temp * 10 + digit
        n /= 10
    }

    if (temp == n1) {
        println("$n1 là số đối xứng")
    } else {
        println("$n1 không phải là số đối xứng")
    }
}


fun bai14() {
    print("Vui lòng nhập a: ")
    var a = readln().toInt()
    print("Vui lòng nhập b: ")
    var b = readln().toInt()

    var temp = 10;
    while ((b/temp) != 0) {
        temp *= 10;
    }
    while ((a/temp) != 0){
        if ((a%temp) == b){
            println("số b nằm trong số a")
            return
        }else{
            a /= 10
        }
    }
    println("số b không nằm trong số a")
}