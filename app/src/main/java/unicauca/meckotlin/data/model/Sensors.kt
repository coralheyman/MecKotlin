package unicauca.meckotlin.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by coral on 21/01/2018.
 */
@Entity(foreignKeys = arrayOf(
        ForeignKey(
                entity = Network::class,
                parentColumns = arrayOf("idNetWork"),
                childColumns = arrayOf("idNetWork"),
                onDelete = ForeignKey.CASCADE)))
class Sensor(
        @PrimaryKey(autoGenerate = true) val idSensor: Long,
        val nameSensor: String,
        val serial: String,
        val stateSensor: Boolean,
        val readingSensor: Boolean,
        val eventsSensor: Boolean,
        val idNetWork: Integer,
        val dateRegister: Date) {
}