package unicauca.meckotlin.ui.main

import android.arch.lifecycle.ViewModel
import unicauca.meckotlin.data.DB
import unicauca.meckotlin.data.dao.NetworkDao
import unicauca.meckotlin.data.model.Network

/**
 * Created by coral on 20/01/2018.
 */
class MainViewModel:ViewModel(){

    private val dao:NetworkDao = DB.con.networkDao()


    fun getNetworks():MutableList<Network>{
        return dao.loadNetworks()
    }

    fun insertNetwork(networks: Network?){
        if (networks != null) {
            dao.insertNetworks(networks)
        }
    }

}