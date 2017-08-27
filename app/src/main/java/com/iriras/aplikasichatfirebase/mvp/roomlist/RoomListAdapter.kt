package com.iriras.aplikasichatfirebase.mvp.roomlist

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.iriras.aplikasichatfirebase.R

/**
 * Created by irfan on 8/27/17.
 */

class RoomListAdapter(private val roomList: List<String>) : RecyclerView.Adapter<RoomListAdapter.RoomListItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomListItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.room_item, parent, false)
        return RoomListItemHolder(view)
    }

    override fun onBindViewHolder(holder: RoomListItemHolder, position: Int) {
        Log.d("Data name ", roomList[position])
        val roomName = roomList[position]
        holder.txtRoomName.text = roomName
    }

    override fun getItemCount(): Int {
        return roomList.size
    }

    inner class RoomListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtRoomName: TextView = itemView.findViewById(R.id.txt_room_name)
    }
}
