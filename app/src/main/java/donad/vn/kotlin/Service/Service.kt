package donad.vn.kotlin.Service

import donad.vn.kotlin.Data.Category
import donad.vn.kotlin.Data.LoginRes
import donad.vn.kotlin.Data.Product
import donad.vn.kotlin.Data.RegisterResponse
import donad.vn.kotlin.Data.User
import donad.vn.kotlin.Data.UserLogin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

// Interface định nghĩa API
interface ApiService {
    @GET("product/getAll")
    suspend fun getProduct(): List<Product>

    @GET("category/get")
    suspend fun getCate(): List<Category>

    @POST("users/register")
    suspend fun register(@Body user: User): RegisterResponse

    @POST("users/login")
    suspend fun loginUser(@Body userLogin: UserLogin): LoginRes

    @GET("product/detailProduct")
    suspend fun getProductDetail(@Query("_id") id: String): Product

    @GET("category/getProductbyIdcate")
    suspend fun getProductByCate(@Path("_id") id: String): List<Product>

}

// Object để khởi tạo Retrofit
object RetrofitInstance {
    private const val BASE_URL = "http://192.168.134.25:3000/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}
