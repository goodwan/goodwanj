import java.time.LocalDateTime

open class DeviceCreate {
    var name: String = ""
    var description: String? = null
    var ownerId: Int = -1
    var profileId: Int = -1
    var timeZoneId: Int? = null
    var statusId: Int = -1
    var scheduleId: Int? = null
    var longitude: Float? = null
    var latitude: Float? = null
    var extId: String? = null
    var pcbId: String? = null
}

@Suppress("EXPERIMENTAL_API_USAGE", "EXPERIMENTAL_UNSIGNED_LITERALS")
class Device: DeviceCreate()
{
    var id: UInt = 0U
    var version: String = ""
}