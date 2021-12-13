package com.example.damproject.Adaptadores

import android.renderscript.RenderScript
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.damproject.Entidades.Persona
import com.example.damproject.R

class AdapterPersona: RecyclerView.Adapter<AdapterPersona.ViewHolder>() {

    var model= arrayListOf<Persona>()
    lateinit var inflater: LayoutInflater


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init{
            itemImage=itemView.findViewById(R.id.item_image)
            itemTitle=itemView.findViewById(R.id.item_title)
            itemDetail=itemView.findViewById(R.id.item_details)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(viewGroup.context).inflate(R.layout.card_client_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text= model[i].nombre1
        viewHolder.itemTitle.text= model[i].nombre2
        viewHolder.itemTitle.text= model[i].apellido1
    }

    override fun getItemCount(): Int {
        return model.size
    }
}