package unicauca.meckotlin.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import unicauca.meckotlin.data.model.Network

/**
 * Created by coral on 21/01/2018.
 */
@Dao
interface NetworkDao {

    @Query("SELECT * FROM network")
    fun loadNetworks():MutableList<Network>

    @Insert
    fun insertNetworks(networks:List<Network>)

    @Insert
    fun insertNetworks(networks:Network)
}