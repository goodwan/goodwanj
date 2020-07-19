import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

@ExperimentalUnsignedTypes
interface IGoodwanApi {
    // devices
    @GET("api/devices")
    fun devices(@Query("id") vararg id: UInt): Call<MutableList<Device>>
}