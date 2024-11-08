import android.os.Parcel
import android.os.Parcelable

data class FlightInfo(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val gender: String,
    val airportCode: String,
    val flightTime: String,
    val flightDate: String,
    val from: String,
    val to: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(email)
        parcel.writeString(gender)
        parcel.writeString(airportCode)
        parcel.writeString(flightTime)
        parcel.writeString(flightDate)
        parcel.writeString(from)
        parcel.writeString(to)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<FlightInfo> {
        override fun createFromParcel(parcel: Parcel): FlightInfo = FlightInfo(parcel)
        override fun newArray(size: Int): Array<FlightInfo?> = arrayOfNulls(size)
    }
}
