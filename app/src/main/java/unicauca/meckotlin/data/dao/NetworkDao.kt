package unicauca.meckotlin.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import unicauca.meckotlin.data.model.Network
import unicauca.meckotlin.data.model.Sensor

/**
 * Created by coral on 21/01/2018.
 */
@Dao
interface NetworkDao {

    @Query("SELECT * FROM network")
    fun loadNetworks(): MutableList<Network>

    @Insert
    fun insertNetworks(networks: List<Network>)

    @Insert
    fun insertNetworks(networks: Network)

    @Insert
    fun inserSensors(sensor: List<Sensor>)

    @Query("SELECT * FROM sensor WHERE idNetWork = :idNet")
    fun loadSensorsByNet(idNet:Long): MutableList<Sensor>

}