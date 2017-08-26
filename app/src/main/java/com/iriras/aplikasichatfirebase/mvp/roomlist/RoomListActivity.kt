package com.iriras.aplikasichatfirebase.mvp.roomlist

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.iriras.aplikasichatfirebase.R
import com.iriras.aplikasichatfirebase.base.BaseActivity

class RoomListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.room_list_activity)
    }

    @SuppressLint("InflateParams")
    private fun dummyDialog(){
        val alertDialog = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val view = inflater.inflate(R.layout.room_dialog, null)
        alertDialog.setView(view)
        val viewDialog = alertDialog.create()
        viewDialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        viewDialog.window.attributes.windowAnimations = R.style.MyDialogAnimation
        viewDialog.show()
    }
}
