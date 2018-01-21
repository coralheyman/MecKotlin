package unicauca.meckotlin.ui.login

import android.arch.lifecycle.ViewModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.uiThread
import unicauca.meckotlin.data.DB
import unicauca.meckotlin.data.dao.DatabaseDao
import unicauca.meckotlin.data.model.User
import kotlin.concurrent.thread

/**
 * Created by coral on 20/01/2018.
 */
class LoginViewModel : ViewModel() {
    private val dao: DatabaseDao = DB.con.dataBaseDao()

    lateinit var users: List<User>

    fun getUserByUsername(username: String): User{
        return dao.selectUserByUsername(username)
    }

    fun getAllUsers() {
        doAsync {
            users = dao.allUsers()
            uiThread {
                if (users.isEmpty()) {
                    loadInfoInitial(User("admin", "1234", "sistemaMEC@gmail.com", "Administrador sistema mec"))
                }
            }
        }
    }


    fun loadInfoInitial(user: User) {
        thread {
            dao.insertUser(user)
        }
    }
}