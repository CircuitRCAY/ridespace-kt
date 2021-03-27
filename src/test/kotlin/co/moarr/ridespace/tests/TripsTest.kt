package co.moarr.ridespace.tests

import co.moarr.ridespace.RideSpace
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThan

class TripsTest : StringSpec({
    "get trips from FSS and check if they have any Glen Waverley services running" {
        val rs = RideSpace.create()

        val fss = rs.tripsById(19854)
        fss[0].trips.filter { it.name.contains("Glen Waverley") }.size shouldBeGreaterThan 0
    }
})