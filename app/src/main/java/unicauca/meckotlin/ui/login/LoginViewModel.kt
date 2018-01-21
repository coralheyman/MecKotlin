package unicauca.meckotlin.ui.login

import android.arch.lifecycle.ViewModel
import unicauca.meckotlin.data.DB
import unicauca.meckotlin.data.dao.DatabaseDao
import unicauca.meckotlin.data.model.User
import kotlin.concurrent.thread

/**
 * Created by coral on 20/01/2018.
 */
class LoginViewModel:ViewModel(){
    private val dao:DatabaseDao = DB.con.dataBaseDao()

    fun getUserByUsername(username:String){
        thread {
            dao.selectUserByUsername(username)
        }
    }
}