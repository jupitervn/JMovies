package vn.jupiter.jmovies.ui.common

import android.app.Activity
import androidx.databinding.DataBindingComponent

class ActivityBindingComponent(activity: Activity) : DataBindingComponent {
    private val adapter = ActivityBindingAdapters(activity)
    override fun getActivityBindingAdapters() = adapter
}
