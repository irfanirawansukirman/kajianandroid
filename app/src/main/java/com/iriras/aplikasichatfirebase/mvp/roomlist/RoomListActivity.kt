package com.iriras.aplikasichatfirebase.mvp.roomlist

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.gson.Gson
import com.iriras.aplikasichatfirebase.R
import com.iriras.aplikasichatfirebase.base.BaseActivity
import kotlinx.android.synthetic.main.room_dialog.view.*
import kotlinx.android.synthetic.main.room_list_activity.*
import kotlinx.android.synthetic.main.toolbar.view.*
import java.util.*
import kotlin.collections.HashSet

class RoomListActivity : BaseActivity() {

    var roomName = String()
    var userName = String()
    var roomList = mutableListOf<String>()
    val root = FirebaseDatabase.getInstance().reference.root

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.room_list_activity)

        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_chat_add_room -> dummyDialog()
            else -> finish()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.chat_room_menu, menu)
        return true
    }

    @SuppressLint("InflateParams")
    private fun dummyDialog() {
        val alertDialog = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val views = inflater.inflate(R.layout.room_dialog, null)
        alertDialog.setView(views)
        val viewDialog = alertDialog.create()
        viewDialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        viewDialog.window.attributes.windowAnimations = R.style.MyDialogAnimation
        viewDialog.show()

        views.btn_roomlistdialog_save.setOnClickListener { view ->
            roomName = views.edtxt_roomlistdialog_name.text.toString()
            userName = views.edtxt_roomlistdialog_username.text.toString()

            val map = HashMap<String, Any>()
            map.put(roomName, "")
            root.updateChildren(map)

            root.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    var set = HashSet<String>()
                    var iterator = dataSnapshot.children.iterator()
                    while (iterator.hasNext()){
                        set.add((iterator.next() as DataSnapshot).key)
                    }
                    roomList.clear()
                    roomList.addAll(set)
                    rec_roomlist.adapter.notifyDataSetChanged()
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }
            })

            var roomAdapter = RoomListAdapter(roomList)
            rec_roomlist.layoutManager = LinearLayoutManager(this)
            rec_roomlist.adapter = roomAdapter

            viewDialog.dismiss()
        }
    }
}
