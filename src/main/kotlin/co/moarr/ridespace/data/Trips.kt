package co.moarr.ridespace.data

import java.time.LocalDateTime

/**
 * Represents a list of trips on endpoints `/api/stop/Train/:id/Trips`.
 *
 * @property name Represents the name of the line.
 * @property trips Represents a list of trip data, which includes capacity levels (if available) for trains and platforms.
 */
data class Trips(val name: String, val trips: List<TripData>)

/**
 * Represents a list of trips on a station.
 *
 * @property tripId the unique integer ID of a trip.
 * @property transportType Represents the [TransportType].
 * [TransportType.TRAIN] is the default to reflect the (lack of) the API's support for other transport types.
 * @property name The name of the railway line that the trip is running on.
 * @property label The name of the trip, including the time when it arrives on the [platform]. Generally used for PIDs.
 * @property subLabel The type of the trip (express, "stopping all stations", etc).
 * @property arrivalTime A [LocalDateTime] object that represents the time arrived at the [platform].
 * @property arrivalLabel A label that provides the current status of the train (scheduled, on time, delayed)
 * @property arrivalType A PascalCase string that represents the current status of the train.
 * @property capacity A string that represents the capacity of the train.
 * @property capacityLevel An integer, ranged presumably from 0-4, that represents the capacity of the train.
 * @property capacityClass A PascalCase string that represents the current capacity status of the train.
 * @property platform A string that represents the number of the train station platform.
 * @property platformCapacityLevel An integer, ranged presumably from 0-4, that represents the capacity of the platform.
 * @property platformCapacityClass A PascalCase string that represents the current capacity status of the platform.
 */
data class TripData(
    val tripId: String,
    val transportType: TransportType = TransportType.TRAIN,
    val name: String,
    val label: String,
    val subLabel: String,
    val stopId: Int,
    val stopName: String,
    val arrivalTime: LocalDateTime,
    val arrivalLabel: String,
    val arrivalType: String,
    val capacity: String?,
    val capacityLevel: Int?,
    val capacityClass: String?,
    val platform: String?,
    val platformCapacity: String?,
    val platformCapacityLevel: Int?,
    val platformCapacityClass: String?
)
