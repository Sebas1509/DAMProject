package com.example.damproject.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.damproject.CustomAdapterProduct
import com.example.damproject.R

class ClientsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clients, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val recycleView=activity?.findViewById<RecyclerView>(R.id.recycleView_client)
        val adapter =CustomAdapterProduct()
        recycleView?.layoutManager=LinearLayoutManager(activity)
        recycleView?.adapter=adapter
    }
}