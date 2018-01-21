package unicauca.meckotlin.data

import android.arch.persistence.room.RoomDatabase
import unicauca.meckotlin.data.dao.DatabaseDao

/**
 * Created by coral on 20/01/2018.
 */

abstract class AppDatabase:RoomDatabase(){

    abstract fun dataBaseDao(): DatabaseDao

}