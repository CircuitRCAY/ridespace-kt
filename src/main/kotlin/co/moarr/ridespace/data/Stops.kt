package co.moarr.ridespace.data

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

/**
 * @property transportType Represents the [TransportType].
 * [TransportType.TRAIN] is the default to reflect the (lack of) the API's support for other transport types.
 * @property stopId Represents a stop ID (may be the same as a station ID).
 * @property stopName Represents a stop (station) name.
 * @property latitude Latitude of the stop.
 * @property longitude Longitude of the stop.
 * @property label The local time when the station is scheduled to reach the stop, as a string.
 * @property arrivalTime A [LocalDateTime] object that represents the time when the stop has been reached.
 * @property arrivalLabel Reflects how close a train has met its time slot (i.e. "EARLY X MINUTES", "ON TIME", "DELAYED X MINUTES")
 * @property arrivalType Reflects the type of arrival ("early", "on time", "late").
 * @property capacity Provides a string representation for the train station capacity.
 * @property capacityClass Provides the PascalCase name of the train station capacity.
 * @property capacityLevel Integer, presumably in the range of 0-4, which represents the station capacity.
 */
data class Stops(
    val transportType: TransportType = TransportType.TRAIN,
    val stopId: Int,
    val stopName: String,
    @SerializedName("lat")
    val latitude: Double,
    @SerializedName("lng")
    val longitude: Double,
    val label: String,
    val arrivalTime: LocalDateTime,
    val arrivalLabel: String,
    // todo: make arrivalType an enum (0.4.0)
    val arrivalType: String,
    val capacity: String,
    val capacityLevel: Int,
    // TODO: make train/station capacity an actual enum (0.4.0)
    val capacityClass: String
)