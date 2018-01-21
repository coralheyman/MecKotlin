package unicauca.meckotlin.adapter

/**
 * Created by coral on 21/01/2018.
 */
import android.content.Context
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import unicauca.meckotlin.R
import unicauca.meckotlin.data.model.Network
import unicauca.meckotlin.util.inflate

import unicauca.meckotlin.databinding.NetworkTemplateBinding

/**
 * Created by Personal on 21/01/2018.
 */

class NetworkAdapter:RecyclerView.Adapter<NetworkHolder>() {

    var onClickNetwork: ((position:Int)->Unit)? = null

    var data:List<Network> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    lateinit var context:Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NetworkHolder(parent.inflate(R.layout.network_template))

    override fun getItemCount(): Int = data.size


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: NetworkHolder, position: Int) {
        holder.bind(data[position],position,this)
    }

    fun onClickNetwork(position: Int){
        onClickNetwork?.invoke(position)
    }
}


class NetworkHolder(view: View): RecyclerView.ViewHolder(view){

    private val binding:NetworkTemplateBinding = DataBindingUtil.bind(view)
    private val v: View = view

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun bind(network: Network, position: Int, handler:NetworkAdapter){

        binding.network = network
        binding.handler = handler
        binding.position = position
        if(network.stateNetwork.equals("Activa")) {
            binding.statusNetwork.text = "Activa"
            binding.imgStatusNetwork.setImageDrawable(v.resources.getDrawable(R.drawable.btn_green, handler.context.theme))
        }else{
            binding.statusNetwork.text = "Inactiva"
            binding.imgStatusNetwork.setImageDrawable(v.resources.getDrawable(R.drawable.btn_red, handler.context.theme))
        }


    }

}