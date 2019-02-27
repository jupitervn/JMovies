package vn.jupiter.jmovies.ui.common

import android.app.Activity
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener

class ActivityBindingAdapters(private val activity: Activity) {
    @BindingAdapter(value = ["imageUrl", "imageRequestListener"], requireAll = false)
    fun bindImage(imageView: ImageView, url: String?, listener: RequestListener<Drawable?>?) {
        Glide.with(activity).load(url).listener(listener).into(imageView)
    }
}
