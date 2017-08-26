package com.iriras.aplikasichatfirebase.util.helper

import android.content.Context

/**
 * Created by irfan on 8/24/17.
 */

fun Float.pxToDp(context: Context, source: Float): Float {
    return source / context.resources.displayMetrics.density
}

fun Float.dpToPx(context: Context, source: Float): Float {
    return source * context.resources.displayMetrics.density
}