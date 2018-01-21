package unicauca.meckotlin.util

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by coral on 21/01/2018.
 */
fun ViewGroup.inflate(@LayoutRes layout:Int): View =
        LayoutInflater.from(context).inflate(layout, this, false)