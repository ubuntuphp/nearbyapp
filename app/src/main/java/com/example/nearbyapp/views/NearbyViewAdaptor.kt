package com.example.nearbyapp.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nearbyapp.R
import com.example.nearbyapp.models.Venues

class NearbyViewAdaptor : RecyclerView.Adapter<NearbyVH>() {
    private val data = ArrayList<Venues>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearbyVH {
        return NearbyVH(LayoutInflater.from(parent.context).inflate(R.layout.layout_nearby_vh,parent,false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: NearbyVH, position: Int) {
        holder.setData(data[position])
    }

    fun addData(locationData:List<Venues>){
        val startPos = data.size
        data.addAll(locationData)
        notifyItemRangeChanged(startPos,locationData.size)
    }

    fun showData(locationData: List<Venues>){
        data.clear()
        data.addAll(locationData)
        notifyDataSetChanged()
    }
}

class NearbyVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val venueNameTv : TextView = itemView.findViewById(R.id.venueNameTv)
    private val venueAddressTv : TextView = itemView.findViewById(R.id.venueAddressTv)

    fun setData(dataModel: Venues){
        venueNameTv.text = dataModel.name
        venueAddressTv.text = dataModel.address
    }
}
