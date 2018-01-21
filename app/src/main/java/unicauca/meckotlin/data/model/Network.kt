package unicauca.meckotlin.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by coral on 20/01/2018.
 */
@Entity
class Network(val nameNetwork:String,
              val ubication:String,
              val descriptionNetwork:String){
    @PrimaryKey(autoGenerate = true)
    var idNetWork:Long? = null

}