package donad.vn.kotlin

fun main(){
    print("Nhap diem kiem tra 15p: ")
    val a =readln().toFloat()
    print("Nhap diem giua ki: ")
    val b = readln().toFloat()
    print("nhap diem cuoi ki: ")
    val c = readln().toFloat()
    val dtb = (a + b * 2 + c * 3)/6

    if(dtb >= 9.5){
        println("Hoc sinh xuat sac")
    }else if( dtb >= 8.0 && dtb <=9.4){
        println("Hoc sinh gioi")
    }else if( dtb >= 6.0 && dtb <=7.9){
        println("Hoc sinh kha")
    }else if( dtb >= 4.0 && dtb <=5.9){
        println("Hoc trung binh")
    }else{
        println("Hoc sinh yeu")
    }

    main1();

}

fun main1(){
    print("nhap cuoc dien thoai: ")
    val time = readln().toInt()
    var sum = 75000
    if(time <= 50){
        sum += time*700
        print("Thanh tien : $sum")
    }else if(time > 50 && time <= 100){
        sum += (50*700) + ((time - 50)*500)
        print("Thanh tien : $sum")
    }else if(time > 150){
        sum += (50*700) + (100*300) + ((time - 100)*300)
        print("Thanh tien : $sum")
    }

}