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

package co.moarr.ridespace.impl

import co.moarr.ridespace.RideSpace
import co.moarr.ridespace.RideSpace.Companion.BASE_URL
import co.moarr.ridespace.data.SearchQuery

import co.moarr.ridespace.data.Station
import co.moarr.ridespace.data.Trips
import co.moarr.ridespace.except.InvalidBodyException
import co.moarr.ridespace.gson.DateDeserialiser

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

import okhttp3.OkHttpClient
import okhttp3.Request
import java.time.Instant
import java.time.LocalDateTime


class RideSpaceImpl(private val client: OkHttpClient) : RideSpace {
    private val gson = GsonBuilder().registerTypeAdapter(LocalDateTime::class.java, DateDeserialiser()).create()

    override fun nearMe(latitude: Double, longitude: Double, radius: Int): List<Station> {
        val request = Request.Builder()
            .url("${BASE_URL}/api/stop/near/${latitude},${longitude},${radius}")
            .build()
        val resp = client.newCall(request).execute()
        val body = resp.body?.string()
        if(body.isNullOrEmpty()) {
            throw InvalidBodyException()
        } else {
            return gson.fromJson(body, object : TypeToken<List<Station?>?>() {}.type)
        }
    }

    override fun search(query: String): List<SearchQuery> {
        val request = Request.Builder()
            .url("${BASE_URL}/api/search?query=${query}")
            .build()

        val resp = client.newCall(request).execute()
        val body = resp.body?.string()
        if(body.isNullOrEmpty()) {
            throw InvalidBodyException()
        } else {
            return gson.fromJson(body, object : TypeToken<List<SearchQuery?>?>() {}.type)
        }
    }

    override fun stopById(id: Int): Station {
        val request = Request.Builder()
            .url("${BASE_URL}/api/stop/Train/${id}?dateTimeUtc=${Instant.now()}")
            .build()
        val resp = client.newCall(request).execute()
        val body = resp.body?.string()
        if(body.isNullOrEmpty()) {
            throw InvalidBodyException()
        } else {
            return gson.fromJson(body, Station::class.java)
        }
    }

    override fun tripsById(id: Int): List<Trips> {
        val request = Request.Builder()
            .url("${BASE_URL}/api/stop/Train/$id/Trips")
            .build()

        val resp = client.newCall(request).execute()
        val body = resp.body?.string()
        if(body.isNullOrEmpty()) {
            throw InvalidBodyException()
        } else {
            return gson.fromJson(body, object : TypeToken<List<Trips?>?>() {}.type)
        }
    }
}