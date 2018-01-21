package unicauca.meckotlin.data

import android.arch.persistence.room.Room
import android.content.Context

/**
 * Created by coral on 20/01/2018.
 */
object DB {

    lateinit var con: AppDatabase

    fun init(context: Context) {
        con = Room.databaseBuilder(context, AppDatabase::class.java, "mec.db")
                .build();
    }


}