![CI Badge](https://github.com/circuitrcay/ridespace-kt/actions/workflows/main.yml/badge.svg) 
[![Release](https://jitpack.io/v/CircuitRCAY/ridespace-kt.svg)](https://jitpack.io/#CircuitRCAY/ridespace-kt)
# RideSpace-Kt
This is a proof-of-concept Kotlin(/JVM) library for the [RideSpace](https://www.ptv.vic.gov.au/more/ridespace/) application, released
by [Public Transport Victoria](https://ptv.vic.gov.au). RideSpace is an application that provides live train locations and "loudness" in train stations.

## Installing
RideSpace-Kt is provided via [JitPack](https://jitpack.io) repositories.
### Maven
```xml
<repositories>
  <repository>
    <id>JitPack</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```
```xml
<dependencies>
  <dependency>
    <groupId>com.github.CircuitRCAY</groupId>
    <artifactId>ridespace-kt</artifactId>
    <version>0.3.0</version>
  </dependency>
</dependencies>
```
### Gradle (Groovy)
```groovy
repositories {
  maven { url "https://jitpack.io" }
}

dependencies {
  implementation group: "com.github.CircuitRCAY", name: "ridespace-kt", version: "0.3.0"
}
```

### Gradle (Kotlin)
```kotlin
repositories {
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation(group = "com.github.CircuitRCAY", name = "ridespace-kt", version = "0.3.0")
}
```

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

## Documentation
API documentation is located at the dedicated domain for RideSpace: https://rs.moarr.co.

## Roadmap
- [x] Search
  - [x] Search by name
  - [x] Search by stop ID
- [x] Near me (using coordinates)
- [x] Trips from a station
- [x] Stops
   - [x] Stops by train trip ID
- [ ] Polygons (in 0.4.0)
  - [ ] Train line polygons (in 0.4.0)
  - [ ] Train station markers (in 0.4.0)
- [ ] Tram, V/Line and bus support (not supported by RideSpace)

## License
RideSpace datasets are licensed under the [Creative Commons Attribution 4.0](https://creativecommons.org/licenses/by/4.0/) license by Public Transport Victoria.

RideSpace-Kt is licensed under the [Apache 2.0](https://github.com/CircuitRCAY/ridespace-kt/blob/master/LICENSE.md) license by Abel Moarrensis.
