package unicauca.meckotlin.ui.main

import android.app.AlertDialog
import android.arch.lifecycle.ViewModelProviders
import android.content.DialogInterface
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_navigation.*
import kotlinx.android.synthetic.main.content_navigation.*
import kotlinx.android.synthetic.main.network_template.*
import kotlinx.android.synthetic.main.template_add_network.*
import org.jetbrains.anko.*
import unicauca.meckotlin.R
import unicauca.meckotlin.adapter.NetworkAdapter
import unicauca.meckotlin.data.model.Network
import unicauca.meckotlin.databinding.TemplateAddNetworkBinding
import unicauca.meckotlin.ui.detailNetwork.DetailActivity

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var data: MutableList<Network> = mutableListOf()
    var networkAdapter: NetworkAdapter = NetworkAdapter()
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        networkAdapter.context = this
        listNetwork.adapter = networkAdapter
        networkAdapter.onClickNetwork = this::goToDetail

        loadData()


    }

    fun loadData() {
        doAsync {
            data = viewModel.getNetworks()
            uiThread { networkAdapter.data = data }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.item_network -> {
                // Handle the camera action
            }
            R.id.item_perfil -> {

            }
            R.id.item_logout -> {
                finish()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun goToDetail(position: Int) {
        startActivity<DetailActivity>("network" to data[position])
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_action_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.createNetwork -> {
                var builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder.setTitle("Crear una nueva red")
                var v: View = layoutInflater.inflate(R.layout.template_add_network, null)
                var binding: TemplateAddNetworkBinding = DataBindingUtil.bind(v)
                var stateNetw: Boolean = false
                binding.stateNet.setOnCheckedChangeListener { buttonView, isChecked -> stateNetw = isChecked }

                builder.setView(v)
                builder.setPositiveButton(R.string.dialog_yes, { dialog: DialogInterface?, which: Int ->
                    run {
                        doAsync {
                            Log.e("hola", stateNetw.toString())
                            var net: Network = Network(binding.nameNet.text.toString(), binding.addNet.text.toString(), stateNetw.toString(), binding.obsNet.text.toString(), "https://i.pinimg.com/originals/33/44/58/3344583bfb0905d5f2ccb53fb84650a1.jpg")
                            viewModel.insertNetwork(net)
                            uiThread { loadData() }
                        }
                    }
                })
                builder.setNegativeButton(R.string.dialog_no, { dialog: DialogInterface?, which: Int -> })
                builder.create().show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
