package co.moarr.ridespace.tests

import co.moarr.ridespace.RideSpace
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import okhttp3.OkHttpClient

class StopsTest : StringSpec({
    "Citybound stops from Bell station cannot be null" {
        val client = OkHttpClient()
        val rs = RideSpace.createWithClient(client)

        rs.tripsById(20013).filter { !it.name.contains("Mernda") }
            .forEach { tr ->
                tr.trips.forEach {
                    rs.trainStopsById(it.stopId) shouldNotBe null
                }
            }
    }
})