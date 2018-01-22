package unicauca.meckotlin.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_navigation.*
import kotlinx.android.synthetic.main.content_navigation.*
import org.jetbrains.anko.startActivity
import unicauca.meckotlin.R
import unicauca.meckotlin.adapter.NetworkAdapter
import unicauca.meckotlin.data.model.Network
import unicauca.meckotlin.ui.detailNetwork.DetailActivity

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var data: MutableList<Network> = mutableListOf()
    var networkAdapter: NetworkAdapter = NetworkAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        networkAdapter.context = this
        listNetwork.adapter = networkAdapter
        networkAdapter.onClickNetwork = this::goToDetail

        loadData()
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


    fun loadData() {
        data.add(Network("Red 1", "Carrera 2", "Activa", "Observaciones red 1", "https://alexdunndev.files.wordpress.com/2017/07/kotlin_tabs.png?w=825&h=510&crop=1"))
        data.add(Network("Red 2", "Carrera 25N # 34-56", "Inactiva", "Observaciones red 2", "https://alexdunndev.files.wordpress.com/2017/07/kotlin_tabs.png?w=825&h=510&crop=1"))
        networkAdapter.data = data
    }

    fun goToDetail(position: Int) {
        startActivity<DetailActivity>("network" to data[position])
    }

}
