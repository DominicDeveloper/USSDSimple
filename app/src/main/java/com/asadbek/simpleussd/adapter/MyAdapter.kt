package com.asadbek.simpleussd.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.asadbek.simpleussd.R
import com.asadbek.simpleussd.models.MyObject

class MyAdapter(val context: Context, private val list:ArrayList<MyObject>, val rvClick:RvClick) : RecyclerView.Adapter<MyAdapter.VH>() {
        inner class VH(var itemRv: View): RecyclerView.ViewHolder(itemRv){
            @SuppressLint("SetTextI18n")
            fun onBind(myObject: MyObject){
                itemRv.findViewById<TextView>(R.id.itemTextViewName).text = myObject.name
                itemRv.findViewById<TextView>(R.id.itemTextViewCode).text =myObject.code
                itemRv.findViewById<TextView>(R.id.itemTextViewAbout).text = myObject.about

                itemRv.setOnClickListener {
                    rvClick.onClick(myObject)
                }
            }
        }


        override fun onBindViewHolder(holder: VH, position: Int) {
            holder.onBind(list[position])
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            return  VH(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun getItemCount(): Int {
            return  list.size
        }
        interface RvClick{
            fun onClick(myObject: MyObject)
        }

}