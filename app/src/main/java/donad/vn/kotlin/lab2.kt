package donad.vn.kotlin

fun main() {
    var choose = true
    while (choose) {
        println("*************************************************************************")
        println("* 1. Xuất ra màn hình các số phạm vi từ 1 -> n                          *")
        println("* 2. Xuất ra màn hình các số chẵn từ 1 -> n                             *")
        println("* 3. Xuất ra màn hình các số lẽ không chia hết cho 3 từ 1 -> n          *")
        println("* 4. S1 = 1 + 2 +..+n                                                   *")
        println("* 5. S2 = - 1 + 2 - 3 + 4 - .. + (-1)^n n.                              *")
        println("* 6. S3 = 1/2 + 2/3 + 3/4... + n/(n+1)                                  *")
        println("* 7. S4 = x^n (x là số thực nhập từ bàn phím).                          *")
        println("* 8. Tính tổng các chữ số của n. Ví dụ: n = 125, tổng các chữ số là 8.  *")
        println("*************************************************************************")
        print("Vui lòng chọn câu (1/2/3/4/5/6/7/8): ")
        var bai = readln().toInt()
        when (bai) {
            1 -> {
                a()
                print("Bạn có muốn chọn tiếp ? (y/n): ")
                var countinue = readln()
                if (countinue.equals("n") || countinue.equals("N")) {
                    choose = false
                }
            }

            2 -> {
                b()
                print("Bạn có muốn chọn tiếp ? (y/n): ")
                var countinue = readln()
                if (countinue.equals("n") || countinue.equals("N")) {
                    choose = false
                }
            }

            3 -> {
                c()
                print("Bạn có muốn chọn tiếp ? (y/n): ")
                var countinue = readln()
                if (countinue.equals("n") || countinue.equals("N")) {
                    choose = false
                }
            }

            4 -> {
                d()
                print("Bạn có muốn chọn tiếp ? (y/n): ")
                var countinue = readln()
                if (countinue.equals("n") || countinue.equals("N")) {
                    choose = false
                }
            }

            5 -> {
                e()
                print("Bạn có muốn chọn tiếp ? (y/n): ")
                var countinue = readln()
                if (countinue.equals("n") || countinue.equals("N")) {
                    choose = false
                }
            }

            6 -> {
                f()
                print("Bạn có muốn chọn tiếp ? (y/n): ")
                var countinue = readln()
                if (countinue.equals("n") || countinue.equals("N")) {
                    choose = false
                }
            }

            7 -> {
                g()
                print("Bạn có muốn chọn tiếp ? (y/n): ")
                var countinue = readln()
                if (countinue.equals("n") || countinue.equals("N")) {
                    choose = false
                }
            }

            8 -> {
                h()
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

fun a() {
    print("Vui lòng nhập số n (n > 0): ")
    var n = readln().toInt()
    print("số có phạm vi từ 1 đến n: ")
    for (i in 1..n) {
        print("$i ")
    }
    println()
}

fun b() {
    print("Vui lòng số n: ")
    var n = readln().toInt()
    print("số chia hết cho 2: ")
    for (i in 1..n) {
        if (i % 2 == 0) {
            print("$i ")
        }
    }
    println()
}

fun c() {
    print("Vui lòng nhập số n: ")
    var n = readln().toInt()
    print("Số lẻ không chia hết cho 3: ")
    for (i in 1..n step 2) {
        if (i % 3 != 0) {
            print("$i ")
        }
    }
    println()
}

fun d() {
    print("Vui lòng nhập số n: ")
    var n = readln().toInt()
    print("S1 = ")
    var sum = 0
    for (i in 1..n) {
        sum += i
    }
    print("$sum")
    println()
}

fun e() {
    print("Vui lòng nhập số n: ")
    var n = readln().toInt()
    print("S2 = ")
    var temp1 = 0
    var temp2 = 0
    for (i in 1..n) {
        if (i % 2 == 0) {
            temp1 += i
        } else {
            temp2 += i * (-1)
        }
    }
    var sum = temp1 + temp2
    print("$sum")
    println()
}


fun f() {
    print("Vui lòng nhập n: ")
    var n = readln().toInt()
    print("S3 = ")
    var sum = 0.0f
    for (i in 1..n) {
        sum += i.toFloat() / (i + 1)
    }
    print("$sum")
    println()
}

fun g() {
    print("Vui lòng nhập n: ")
    var n = readln().toInt()
    print("Vui lòng nhập x: ")
    var x = readln().toFloat()
    print("S4 = ")

    var result = 1f
    for (i in 1..n) {
        result *= x
    }

    println("$result")
}

fun h() {
    print("Vui lòng nhập số n: ")
    var n = readln().toInt()
    print("Tổng các chữ số của n: ")
    var sum = 0
    while (n != 0) {
        sum += n % 10
        n /= 10
    }
    println("$sum")
}
