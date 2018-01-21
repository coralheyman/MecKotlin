package unicauca.meckotlin.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import unicauca.meckotlin.data.dao.DatabaseDao
import unicauca.meckotlin.data.model.User;

/**
 * Created by coral on 20/01/2018.
 */

@Database(entities = [User::class], version = 1)
abstract class AppDatabase:RoomDatabase(){

    abstract fun dataBaseDao(): DatabaseDao

}