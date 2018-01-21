package unicauca.meckotlin.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import unicauca.meckotlin.data.model.User

/**
 * Created by coral on 20/01/2018.
 */
@Dao
interface DatabaseDao {

    @Query(value = "SELECT * FROM user WHERE username = :username")
    fun selectUserByUsername(username: String): User

    @Query("SELECT * FROM user")
    fun allUsers(): List<User>

    @Insert
    fun insertUser(user: User)

}