package com.iriras.aplikasichatfirebase.util.helper

import android.content.Context

/**
 * Created by irfan on 8/24/17.
 */

fun Int.pxToDp(context: Context, source: Int): Int {
    return (source / context.resources.displayMetrics.density).toInt()
}

fun Int.dpToPx(context: Context, source: Int): Int {
    return (source * context.resources.displayMetrics.density).toInt()
}