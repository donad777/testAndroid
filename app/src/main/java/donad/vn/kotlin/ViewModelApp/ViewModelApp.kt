package donad.vn.kotlin.ViewModelApp

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import donad.vn.kotlin.Data.Category
import donad.vn.kotlin.Data.LoginRes
import donad.vn.kotlin.Data.Product
import donad.vn.kotlin.Data.RegisterResponse
import donad.vn.kotlin.Data.User
import donad.vn.kotlin.Data.UserLogin
import donad.vn.kotlin.Service.RetrofitInstance


public class ViewModelApp : ViewModel(){
    private val _product = mutableStateOf<List<Product>>(emptyList())
    val products: State<List<Product>> = _product

    private val _category = mutableStateOf<List<Category>>(emptyList())
    val categories: State<List<Category>> = _category

    private val _registerResponse = mutableStateOf<RegisterResponse?>(null)
    val registerResponse: State<RegisterResponse?> = _registerResponse

    private val _loginRespone = mutableStateOf<LoginRes?>(null)
    val loginResponse: State<LoginRes?> = _loginRespone

    private val _productDetail = mutableStateOf<Product?>(null)
    val productDetail: State<Product?> = _productDetail

    public fun getProductViewModel() {
        viewModelScope.launch {
            try {
                _product.value = RetrofitInstance.api.getProduct()
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======",e.toString())
            }
        }
    }
    public fun getCate() {
        viewModelScope.launch {
            try {
                _category.value = RetrofitInstance.api.getCate()
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======",e.toString())
            }
        }
    }

    fun registerUser(email: String, fullName: String, password: String) {
        viewModelScope.launch {
            try {
                val user = User(email, fullName, password)
                val response = RetrofitInstance.api.register(user)
                _registerResponse.value = response
            } catch (e: Exception) {
                Log.d("Lỗi Đăng Ký", e.toString())
            }
        }
    }

    fun login(login: UserLogin) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.loginUser(login)
                _loginRespone.value = response  // Cập nhật giá trị trả về
            } catch (e: Exception) {
                Log.d("Login Error", e.toString()) // Thêm log lỗi
                _loginRespone.value = LoginRes(message = "Đăng nhập thất bại. Vui lòng thử lại.")

            }
        }
    }

    fun getProductDetail(_id: String) {
        viewModelScope.launch {
            try {
                _productDetail.value = RetrofitInstance.api.getProductDetail(_id)
            } catch (e: Exception) {
                Log.d("Product Detail Error", e.toString())
                _productDetail.value = null // Hoặc xử lý theo cách khác nếu cần
            }
        }
    }

    fun getProductByCate(_id: String) { // categoryId không nên null
        viewModelScope.launch {
            try {
                // Gọi API với query parameter
                _product.value = RetrofitInstance.api.getProductByCate(_id)
            } catch (e: Exception) {
                Log.d("Lỗi Lấy Sản Phẩm", e.toString())
            }
        }
    }
}
