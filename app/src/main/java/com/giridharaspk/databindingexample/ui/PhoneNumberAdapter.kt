package com.giridharaspk.databindingexample.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giridharaspk.databindingexample.databinding.ItemPhoneNumberBinding
import com.giridharaspk.databindingexample.data.model.PhoneNumber

class PhoneNumberAdapter(val context: Context, val list: ArrayList<PhoneNumber>) :
    RecyclerView.Adapter<PhoneNumberAdapter.PhoneNumberViewHolder>() {

    class PhoneNumberViewHolder(val binding: ItemPhoneNumberBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneNumberViewHolder {
        val binding = ItemPhoneNumberBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PhoneNumberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhoneNumberViewHolder, position: Int) {
        holder.binding.phoneNumber = list[position]
    }

    override fun getItemCount() = list.size
}