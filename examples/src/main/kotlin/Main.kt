import com.google.gson.GsonBuilder
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BasicAuthInterceptor(username: String, password: String) : Interceptor {
    private var credentials: String = Credentials.basic(username, password)

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder().header("Authorization", credentials).build()
        return chain.proceed(request)
    }
}

@ExperimentalUnsignedTypes
fun main(args: Array<String>) {
    val client = OkHttpClient.Builder()
            .addInterceptor(BasicAuthInterceptor("asysoev@mail.ru", ""))
            .build()

    val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()

    val retrofit: Retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://my.goodwan.ru/")
            .build()

    val api = retrofit.create(IGoodwanApi::class.java)
    val response = api.devices(4U, 386U).execute()
    val devices = response.body()
    if (response.isSuccessful && devices != null) {
        for (dev in devices) {
            println("id=${dev.id}, version=${dev.version}")
        }
    }
}