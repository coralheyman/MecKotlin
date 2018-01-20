package unicauca.meckotlin.data.model

/**
 * Created by coral on 20/01/2018.
 */

class User (val username:String,
            val password:String,
            val email:String,
            val nameUser:String) {

    //@PrimaryKey(autoGenerate = true)
    var id:Long? = null

}