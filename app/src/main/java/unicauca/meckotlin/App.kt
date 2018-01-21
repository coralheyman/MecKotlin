package unicauca.meckotlin

import android.app.Application
import unicauca.meckotlin.data.DB

/**
 * Created by coral on 21/01/2018.
 */
class App:Application() {
    override fun onCreate() {
        super.onCreate()
        DB.init(this)
    }
}