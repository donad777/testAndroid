package donad.vn.kotlin.Data

data class Product(
    val _id: String,
    val productName: String,
    val description: String,
    val price: Int,
    val image: String,
    val category: String
)

data class Category(
    val _id: String,
    val cateName: String,
    val image: String,
)

data class User(
    val email: String,
    val fullName: String,
    val password: String
)

data class UserLogin(
    val email: String,
    val password: String
)

// Data class cho phản hồi đăng ký
data class RegisterResponse(
    val success: Boolean,
    val message: String
)

data class LoginRes(
    val message: String
)