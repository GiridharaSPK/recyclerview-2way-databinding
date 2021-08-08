package com.giridharaspk.databindingexample.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giridharaspk.databindingexample.databinding.ItemEmployeeBinding
import com.giridharaspk.databindingexample.data.model.Employee

class EmployeeAdapter(val context: Context, val list: ArrayList<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    lateinit var clickListener: EmployeeClickListener

    inner class EmployeeViewHolder(val binding: ItemEmployeeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val itemEmployeeBinding = ItemEmployeeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val viewHolder = EmployeeViewHolder(itemEmployeeBinding)
        viewHolder.binding.adapter = this
        return viewHolder
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val emp = list[position]
        holder.binding.emp = emp
//        holder.binding.clItem.setOnClickListener {
//            clickListener.employeeClickListener(emp)
//            showEmployeeDetails(emp)
//        }
    }
/*
    fun showEmployeeDetails(emp: Employee) {
        Log.e("showEmpDetails", emp.toString())
        try {
            val bundle = Bundle()
            bundle.putSerializable("emp", emp)
            val intent = Intent(context, EmployeeDetailsActivity::class.java)
            intent.putExtra("bundle", bundle)
            context.startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }*/

    override fun getItemCount() = list.size

    interface EmployeeClickListener {
        fun showEmpDetails(emp: Employee)
    }

}