package io.github.sphrak.nestedrecyclerviewkotlin

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class NestedApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this);
    }

}