package unicauca.meckotlin.util

import android.databinding.BindingAdapter
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by coral on 21/01/2018.
 */
val dateFormat =  SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())

@BindingAdapter("app:imgUrl")
fun setImageByUrl(image: ImageView, url:String){
    Picasso.with(image.context)
            .load(Uri.parse(url))
            .into(image)
}

@BindingAdapter("app:dateFormat")
fun setDateText(txt: TextView, date:Date){
    txt.text = dateFormat.format(date)
}