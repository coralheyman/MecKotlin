package unicauca.meckotlin.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

/**
 * Created by coral on 20/01/2018.
 */
@Dao
interface DatabaseDao{

    @Query(value = "SELECT * FROM user WHERE username = :username")
    fun selectUserByUsername(username:String)

}