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
 * Represents a search query for a train station.
 * @property transportType Represents the [TransportType].
 * [TransportType.TRAIN] is the default to reflect the (lack of) the API's support for other transport types.
 * @property results A list of [SearchResult]s, that provide data on the train station.
 */
data class SearchQuery(val transportType: TransportType = TransportType.TRAIN,
                       val results: List<SearchResult>
)

/**
 * Represents a single [SearchResult] in a search query.
 * @property resultType A string, generally the "Stop" string.
 * @property id A nullable integer that represents the station ID. Hardcoded to be null, even for FSS.
 * @property name The name of the train station and its alias.
 * @property label Generally unused, presumably the alias for the station.
 * @property latitude The latitude coordinate for the station.
 * @property longitude The longitude coordinate for the station.
 */
data class SearchResult(val resultType: String,
                        val id: Int?,
                        val name: String,
                        val label: String?,
                        @SerializedName("lat")
                        val latitude: Double,
                        @SerializedName("lng")
                        val longitude: Double
)