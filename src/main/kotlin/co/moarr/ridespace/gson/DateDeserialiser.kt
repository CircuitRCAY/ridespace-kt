package co.moarr.ridespace.gson

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.time.LocalDateTime
import java.time.OffsetDateTime

class DateDeserialiser : JsonDeserializer<LocalDateTime> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): LocalDateTime {
        val date = json!!.asString
        try {
            val offset = OffsetDateTime.parse(date)
            return offset.toLocalDateTime()
        } catch (e: Exception) {
            throw JsonParseException(e)
        }
    }
}