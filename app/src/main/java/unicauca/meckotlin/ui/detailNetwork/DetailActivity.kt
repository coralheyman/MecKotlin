package unicauca.meckotlin.ui.detailNetwork

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.design.collapsingToolbarLayout
import unicauca.meckotlin.R
import unicauca.meckotlin.adapter.SensorAdapter
import unicauca.meckotlin.data.model.Network
import unicauca.meckotlin.data.model.Sensor

class DetailActivity : AppCompatActivity() {

    var data: MutableList<Sensor> = mutableListOf()
    var sensorAdapter: SensorAdapter = SensorAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val network: Network = intent.extras.getParcelable("network")

        setSupportActionBar(toolbar)
        //collapsingToolbarLayout().title = network.nameNetwork
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        titleBar.title = network.nameNetwork

        Picasso.with(this).load(Uri.parse(network.imgNetwork)).into(barImgNetwork)

        listSensor.adapter = sensorAdapter
        loadData()
    }

    fun loadData(){
        data.add(Sensor(123456,"Sensor 1", "123ERFDSA", true, false, true,  1, "12-01-2018"))
        sensorAdapter.data = data
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return false
    }
}
