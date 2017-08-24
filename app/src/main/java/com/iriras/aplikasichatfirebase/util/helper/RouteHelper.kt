package com.iriras.aplikasichatfirebase.util.helper

import android.content.Context
import android.content.Intent

/**
 * Created by irfan on 8/24/17.
 */

class RouteHelper {
    companion object {
        fun startThisActivity(context: Context, activity: Class<*>) {
            val intent = Intent(context, activity)
            context.startActivity(intent)
        }
    }
}
