package com.iriras.aplikasichatfirebase.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.iriras.aplikasichatfirebase.R
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

/**
 * Created by irfan on 8/23/17.
 */

abstract class BaseActivity : AppCompatActivity() {
    var mActivity:AppCompatActivity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActivity = this

        //set default font
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro.regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build())
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }
}