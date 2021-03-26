# RideSpace-Kt
This is a proof-of-concept Kotlin(/JVM) library for the [RideSpace](https://www.ptv.vic.gov.au/more/ridespace/) application, released
by [Public Transport Victoria](https://ptv.vic.gov.au). RideSpace is an application that provides live train locations and "loudness" in train stations.

## Installing
[coming soon]

## How to use
A very minimal example, that searches for stations with a set of coordinates.
```kotlin
fun main() {
    val ridespace = RideSpace.create()
    /* Coordinates for a point near Flinders St Station */
    val lat = -37.82036749475393
    val long = 144.95723729942
    /* Search radius */
    val radius = 2000
    
    val stations = ridespace.nearMe(lat, long, radius)
    
    val firstStation = stations[0]
    
    print(firstStation.name)
}
```

## Roadmap
- [x] Search
  - [x] Search by name
  - [ ] Search by stop ID (non-API method)
- [x] Near me (using coordinates)
- [ ] Trips from a station

## License
RideSpace datasets are licensed under the [Creative Commons Attribution 4.0](https://creativecommons.org/licenses/by/4.0/) license by Public Transport Victoria.

RideSpace-Kt is licensed under the [Apache 2.0](https://github.com/CircuitRCAY/ridespace-kt/blob/master/LICENSE.md) license by Abel Moarrensis.
