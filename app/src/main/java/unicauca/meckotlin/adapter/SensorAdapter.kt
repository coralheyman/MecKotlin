package unicauca.meckotlin.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import unicauca.meckotlin.R
import unicauca.meckotlin.data.model.Sensor
import unicauca.meckotlin.databinding.SensorTemplateBinding
import unicauca.meckotlin.util.inflate

/**
 * Created by Personal on 21/01/2018.
 */
class SensorAdapter: RecyclerView.Adapter<SensorHolder>(){

    var data:List<Sensor> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SensorHolder(parent.inflate(R.layout.sensor_template))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SensorHolder, position: Int) {
        holder.bind(data[position], position, this)
    }


}


class SensorHolder(view: View): RecyclerView.ViewHolder(view){

    private val binding:SensorTemplateBinding = DataBindingUtil.bind(view)
    private val v: View = view

    fun bind(sensor: Sensor, position: Int, handler: SensorAdapter){

        binding.sensor = sensor

    }

}