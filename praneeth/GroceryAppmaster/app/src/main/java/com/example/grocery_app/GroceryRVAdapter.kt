package com.example.grocery_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

class GroceryRVAdapter(
    var list: List<GroceryItems>,
    private val groceryItemClickInterface: GroceryItemClickInterface
) : RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>() {


    inner class GroceryViewHolder(itemVIew: View) : RecyclerView.ViewHolder(itemVIew) {
        val nameTV = itemView.findViewById<TextView>(R.id.idTVItemName)
        val quantityTV = itemView.findViewById<TextView>(R.id.idTVQuantity)
        val rateTV = itemView.findViewById<TextView>(R.id.idTVRate)
        val amountTV = itemView.findViewById<TextView>(R.id.idTVTotalAmt)
        val DeleteIV = itemView.findViewById<ImageView>(R.id.idTVItemName)
    }

    interface GroceryItemClickInterface {
        fun onItemClick(GroceryItems: GroceryItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_item,parent,  false)
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        holder.nameTV.text=list.get(position).itemName
        holder.quantityTV.text=list.get(position).itemQuantity.toString()
        holder.rateTV.text="Rs  "+list.get(position).itemPrice.toString()
        val itemTotal: Int =list.get(position).itemPrice*list.get(position).itemQuantity
        holder.amountTV.text="rs  "+itemTotal.toString()
        holder.DeleteIV.setOnClickListener {
            groceryItemClickInterface.onItemClick(list.get(position))
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

}