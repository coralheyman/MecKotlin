package unicauca.meckotlin.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import unicauca.meckotlin.data.dao.DatabaseDao
import unicauca.meckotlin.data.dao.NetworkDao
import unicauca.meckotlin.data.model.Network
import unicauca.meckotlin.data.model.Sensor
import unicauca.meckotlin.data.model.User;
import java.util.*

/**
 * Created by coral on 20/01/2018.
 */

class Converter {
    @TypeConverter
    fun dateToLong(date: Date): Long = date.time

    @TypeConverter
    fun longToDate(long: Long): Date = Date(long)

}

@TypeConverters(Converter::class)
@Database(entities = arrayOf(User::class, Network::class, Sensor::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dataBaseDao(): DatabaseDao

    abstract fun networkDao(): NetworkDao

}