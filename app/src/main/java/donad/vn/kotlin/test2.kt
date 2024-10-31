package donad.vn.kotlin

fun main(){
    var choose = true
    while (choose){
        print("Vui lòng chọn bài (1/2/3): ")
        var bai = readln().toInt()
        when(bai){
            1 -> {
                bai1()
                print("Bạn có muốn chọn tiếp ? (y/n): ")
                var countinue = readln()
                if (countinue.equals("n") || countinue.equals("N")){
                    choose = false
                }
            }
            2 -> {
                bai2()
                print("Bạn có muốn chọn tiếp ? (y/n): ")
                var countinue = readln()
                if (countinue.equals("n") || countinue.equals("N")){
                    choose = false
                }
            }
            3 -> {
                bai3()
                print("Bạn có muốn chọn tiếp ? (y/n): ")
                var countinue = readln()
                if (countinue.equals("n") || countinue.equals("N")){
                    choose = false
                }
            }
            else -> {
                println("Vui lòng chọn đúng bài!")
            }
        }
    }
}

fun bai1(){
    print("Vui lòng nhập a: ")
    var a = readln().toInt()

    var firstNumber = a

    while (firstNumber >= 10){
        firstNumber /= 10
    }
    println("Chữ số đầu tiên của a: $firstNumber")

    if (a % 2 == 0){
        println("a là số chẵn")
    }else{
        println("a là số lẻ")
    }

    var check = true
    var first = a % 10 // lay so cuoi dung
    a /= 10 // bo so cuoi cung

    while ( a > 0){
        var seccond = a % 10 //  lay so cuoi cung cua a
        if ( seccond < first){
            check =  false
            break
        }
        first = seccond // cap nhat cho first de kiem tra tiep
        a /= 10 // loai bo so da kiem tra
    }
    if (check){
        println("A là số giảm dần")
    }else{
        println("Không phải là số giảm dần")
    }

}

fun bai2(){
    var check = true
    while (check){
        print("Vui lòng nhập giờ bắt đầu: ")
        var on = readln().toInt()
        print("Vui lòng nhập giờ kết thúc: ")
        var off = readln().toInt()

        if (on < 7 || off > 23 || on >= off){
            println("Thời gian không hợp lệ. Vui lòng nhập lại!")
        }else{
            check = false
            var time = off - on
            var money = 0
            if (time >= 2){
                money += 20000
            }else{
                money += 10000 * time
            }
            if ( time > 4 ){
                var saleTime = time -4
                money += 20000 // Thêm tiền cho giờ thứ 3 và thứ 4 (2 giờ này không giảm giá)
                money += (10000 * saleTime * 0.85).toInt()  // Giảm 15% cho các giờ từ thứ 5 trở đi
            }else if (time > 2){
                // Nếu từ 3 đến 4 giờ, tính tiền 2 giờ tiếp theo mà không giảm giá
                money += 10000*( time - 2 )
            }
            //check golden time
            if ( on in 14 .. 16){
                money = (money * 0.9).toInt()
            }
            println("Tổng tiền: $money VNĐ")
        }
    }
}

fun bai3(){
    print("Nhập giá tiền laptop: ")
    var priceLaptop = readln().toInt()
    var tiengocconlai = priceLaptop
    val month = 6
    for (i in 1..month){
        var pay = priceLaptop/month
        tiengocconlai -= pay
        var lai = tiengocconlai * 0.01
        var sum = pay + lai
        println("Tháng ${i}")
        println("Số tiền gốc còn lại: $tiengocconlai")
        println("số tiền gốc cần phải trả: $pay")
        println("số tiền lãi trong tháng: $lai")
        println("số tiền cần phải trả: $sum")
    }
}