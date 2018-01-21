package unicauca.meckotlin.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by coral on 20/01/2018.
 */

@Entity(tableName = "user")
class User (val username:String,
            val password:String,
            val email:String,
            val nameUser:String) {

    @PrimaryKey(autoGenerate = true)
    var id:Long? = null

}