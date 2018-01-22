package unicauca.meckotlin.ui.login

import android.arch.lifecycle.ViewModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.uiThread
import unicauca.meckotlin.data.DB
import unicauca.meckotlin.data.dao.DatabaseDao
import unicauca.meckotlin.data.dao.NetworkDao
import unicauca.meckotlin.data.model.Network
import unicauca.meckotlin.data.model.Sensor
import unicauca.meckotlin.data.model.User
import kotlin.concurrent.thread

/**
 * Created by coral on 20/01/2018.
 */
class LoginViewModel : ViewModel() {
    private val dao: DatabaseDao = DB.con.dataBaseDao()
    private val dao2: NetworkDao = DB.con.networkDao()

    lateinit var users: List<User>

    fun getUserByUsername(username: String): User {
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
            var data: MutableList<Network> = mutableListOf()
            data.add(Network("Red 1", "Carrera 2", "true", "Observaciones red 1", "https://alexdunndev.files.wordpress.com/2017/07/kotlin_tabs.png?w=825&h=510&crop=1"))
            data.add(Network("Red 2", "Carrera 25N # 34-56", "false", "Observaciones red 2", "https://alexdunndev.files.wordpress.com/2017/07/kotlin_tabs.png?w=825&h=510&crop=1"))
            dao2.insertNetworks(data)
            //cargar sensores
            var data2: MutableList<Sensor> = mutableListOf()
            data2.add(Sensor(123456,"Sensor 1", "123ERFDSA", true, false, true,  1, "12-01-2018"))
            data2.add(Sensor(106123,"Sensor 45", "123ERFDSA-4", true, false, true,  1, "13-01-2018"))
            dao2.inserSensors(data2)
            var data3: MutableList<Sensor> = mutableListOf()
            data3.add(Sensor(23432,"Sensor 13", "123ERFDSBG", true, false, true,  2, "14-12-2017"))
            data3.add(Sensor(345653,"Sensor 15", "123ERFDSA-4", true, false, true,  2, "13-11-2017"))
            data3.add(Sensor(23424,"Sensor 65", "ED3ERFDSA-4", true, false, true,  2, "13-11-2017"))
            data3.add(Sensor(3455,"Sensor 32", "123ERFDSSA-4", true, false, true,  2, "13-11-2017"))
            dao2.inserSensors(data3)
        }
    }
}