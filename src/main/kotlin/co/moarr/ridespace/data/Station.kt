/*
   Copyright 2021 Abel Moarrensis

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package co.moarr.ridespace.data

import com.google.gson.annotations.SerializedName

/**
 * Represents a station object in endpoints `/api/stop/near`.
 * @property id Represents a station ID.
 * @property transportType Represents the [TransportType].
 * [TransportType.TRAIN] is the default to reflect the (lack of) the API's support for other transport types.
 * @property name Represents the name of a station.
 * @property label Provides the location of a station in the format of `in (Suburb)`
 * @property capacity Provides a string representation for the train station capacity.
 * @property capacityClass Provides the PascalCase name of the train station capacity.
 * @property capacityLevel Integer, presumably in the range of 0-4, which represents the station capacity.
 * @property distance Distance (in metres) from the coordinates.
 * @property latitude The latitude of the station.
 * @property longitude The longitude of the station.
 */
data class Station(val id: Int,
                   val transportType: TransportType = TransportType.TRAIN,
                   val name: String,
                   val label: String,
                   val capacity: String,
                   val capacityLevel: Int,
                   // TODO: make train/station capacity an actual enum (0.4.0)
                   val capacityClass: String,
                   val distance: Int,
                   @SerializedName("lat")
                   val latitude: Double,
                   @SerializedName("lng")
                   val longitude: Double
)