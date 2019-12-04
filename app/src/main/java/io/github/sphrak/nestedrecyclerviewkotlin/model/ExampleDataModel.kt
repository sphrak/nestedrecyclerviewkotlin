package io.github.sphrak.nestedrecyclerviewkotlin.model

import org.threeten.bp.OffsetDateTime

data class ExampleDataModel(
    val time: OffsetDateTime,
    val weather: List<WeatherDataModel>
)