package com.ubaya.adv160421055_week6.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ubaya.adv160421055_week6.databinding.MotorcycleListItemBinding
import com.ubaya.adv160421055_week6.model.motorcycle

class motorcycleListAdapter (val motorcycleList:ArrayList<motorcycle>)
    : RecyclerView.Adapter<motorcycleListAdapter.motorcycleViewHolder>() {
    class motorcycleViewHolder(var binding: MotorcycleListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): motorcycleViewHolder {
        val binding = MotorcycleListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return motorcycleViewHolder(binding)
    }
    override fun onBindViewHolder(holder: motorcycleViewHolder, position: Int) {
        Picasso.get().load(motorcycleList[position].images).into(holder.binding.imageView)
        holder.binding.txtID.text ="ID:" +(motorcycleList[position].id).toString()
        holder.binding.txtBrand.text ="Brand:" +motorcycleList[position].brand
        holder.binding.txtModel.text ="Model:" + motorcycleList[position].model
        holder.binding.txtYear.text = "Year:" +(motorcycleList[position].year).toString()
        holder.binding.txtType.text = "Type:" +motorcycleList[position].engine.type
        holder.binding.txtDisplacement.text ="Displacement:" + motorcycleList[position].engine.displacement
        holder.binding.txtColor.text = "Color:" +motorcycleList[position].colors?.joinToString(", ")
        holder.binding.txtPrice.text = "Price:" +(motorcycleList[position].price).toString()
    }
    fun updateMotorcycleList(newMotorcycleList: ArrayList<motorcycle>) {
        motorcycleList.clear()
        motorcycleList.addAll(newMotorcycleList)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return motorcycleList.size
    }
}