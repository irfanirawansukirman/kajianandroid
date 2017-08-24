package com.iriras.aplikasichatfirebase.mvp.chat

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.iriras.aplikasichatfirebase.R
import com.iriras.aplikasichatfirebase.base.BaseActivity
import com.iriras.aplikasichatfirebase.mvp.chatroomlist.ChatRoomListActivity
import com.iriras.aplikasichatfirebase.util.helper.RouteHelper
import org.jetbrains.anko.find

class ChatActivity : BaseActivity() {

    private val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_activity)

        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_chat_add_room -> RouteHelper.startThisActivity(this, ChatRoomListActivity::class.java)
            else -> finish()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.chat_menu, menu)
        return true
    }
}
