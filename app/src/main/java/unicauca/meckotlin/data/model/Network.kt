package unicauca.meckotlin.data.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by coral on 20/01/2018.
 */
@SuppressLint("ParcelCreator")
@Entity
@Parcelize
class Network(val nameNetwork:String,
              val addressNetwork:String,
              val stateNetwork:String,
              val obsNetwork:String,
              val imgNetwork: String): Parcelable {
    @PrimaryKey(autoGenerate = true)
    var idNetWork:Long? = null

}