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
package co.moarr.ridespace

import co.moarr.ridespace.data.SearchQuery
import co.moarr.ridespace.data.Station
import co.moarr.ridespace.data.Stops
import co.moarr.ridespace.data.Trips
import co.moarr.ridespace.impl.RideSpaceImpl
import okhttp3.OkHttpClient

interface RideSpace {
    /**
     * Returns the list of stations near a set of coordinates in a blocking method.
     *
     * @param latitude The latitude of a coordinate.
     * @param longitude The longitude of a coordinate.
     * @param radius The radius from the [latitude] and the [longitude] to search from.
     */
    fun nearMe(latitude: Double, longitude: Double, radius: Int): List<Station>

    /**
     * Returns a list of stations in a search query.
     *
     * @param query A string to search with.
     */
    fun search(query: String): List<SearchQuery>

    /**
     * Gets station data by a stop ID. Uses the current time, as RideSpace does not support historical data.
     *
     * @param id A stop ID that pertains to a station.
     */
    fun stopById(id: Int): Station

    /**
     * Gets a list of trips by a stop ID.
     *
     * @param id A stop ID that pertains to a station.
     */
    fun tripsById(id: Int): List<Trips>

    /**
     * Retrieves stops by a train trip ID. Uses the current time, as RideSpace does not support historical data.
     *
     * @param id A train trip ID.
     */
    fun trainStopsById(id: Int): List<Stops>

    companion object {
        const val BASE_URL = "https://ridespace.coronavirus.vic.gov.au"

        lateinit var client: OkHttpClient

        /**
         * Creates a [RideSpace] instance with a custom [OkHttpClient].
         *
         * @param client The OkHttp client.
         *
         * @return A [RideSpace] instance.
         */
        fun createWithClient(client: OkHttpClient): RideSpace {
            this.client = client
            return RideSpaceImpl(this.client)
        }

        /**
         * Creates a [RideSpace] instance with default options.
         *
         * @return A [RideSpace] instance.
         */
        fun create(): RideSpace {
            this.client = OkHttpClient()
            return RideSpaceImpl(this.client)
        }
    }
}