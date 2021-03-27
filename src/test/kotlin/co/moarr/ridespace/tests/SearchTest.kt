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

package co.moarr.ridespace.tests

import co.moarr.ridespace.RideSpace
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldNotBe
import okhttp3.OkHttpClient

class SearchTest : StringSpec({
    "search for the Mernda station" {
        val client = OkHttpClient()
        val rs = RideSpace.createWithClient(client)

        val results = rs.search("Mernda")

        results[0].results.filter { it.name.contains("Mernda") }.size shouldBeGreaterThan 0
    }

    "search for the Glen Waverley station with RideSpace.Companion#create" {
        val rs = RideSpace.create()
        val query = rs.search("Glen Waverley")

        query[0].results.filter { it.name.contains("Glen Waverley") }.size shouldBeGreaterThan 0
    }

    "get Ringwood station by ID and check if the capacity is not 'null'" {
        val rs = RideSpace.create()
        val ringwood = rs.stopById(19902)
        ringwood.capacity shouldNotBe null
    }
})