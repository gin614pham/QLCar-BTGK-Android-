package com.example.qlcar21it640.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qlcar21it640.CarModel
import com.example.qlcar21it640.R

class RvAdapter(private val carList: ArrayList<CarModel>, val onClick: RvDetail) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tVCarID : AppCompatTextView = itemView.findViewById(R.id.tVCarID)
        val tVCarName : AppCompatTextView = itemView.findViewById(R.id.tVCarName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_car, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = carList[position]
        holder.tVCarID.text = car.carID
        holder.tVCarName.text = car.carName
        // set onClick Listener
        holder.itemView.setOnClickListener {
            onClick.onClick(position)
        }
    }

}
