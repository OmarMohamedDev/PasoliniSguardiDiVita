package com.omd.pasolinisdv.extensions

import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity

/**
 * Remember to set the android:parentActivityName attribute on the activity you are calling this
 * from!
 */
fun AppCompatActivity.enableToolbarBackButton() {
    delegate.supportActionBar?.setDisplayHomeAsUpEnabled(true)
}

fun BottomNavigationView.OnNavigationItemSelectedListener() {
    
}
