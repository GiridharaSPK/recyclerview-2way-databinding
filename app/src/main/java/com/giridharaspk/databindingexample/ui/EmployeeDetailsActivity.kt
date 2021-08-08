package com.giridharaspk.databindingexample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.giridharaspk.databindingexample.R
import com.giridharaspk.databindingexample.databinding.ActivityEmployeeDetailsBinding
import com.giridharaspk.databindingexample.data.model.Employee

class EmployeeDetailsActivity : AppCompatActivity() {

    lateinit var adapter: PhoneNumberAdapter
    lateinit var binding: ActivityEmployeeDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_employee_details)
        val bundle = intent.getBundleExtra("bundle")
        val emp = bundle?.get("emp") as Employee?
        if (emp != null) {
            showEmpDetails(emp)

            val list = emp.phoneNumbers
            adapter = PhoneNumberAdapter(this@EmployeeDetailsActivity, list)

            binding.emp = emp

            binding.rvPhoneNums.apply {
                layoutManager = LinearLayoutManager(this@EmployeeDetailsActivity)
                hasFixedSize()
                adapter = this@EmployeeDetailsActivity.adapter
            }

            binding.btShow.setOnClickListener {
                showEmpDetails(emp)
            }
        }
    }

    private fun showEmpDetails(emp: Employee) {
        binding.empDetails.text = emp.toString()
    }

}