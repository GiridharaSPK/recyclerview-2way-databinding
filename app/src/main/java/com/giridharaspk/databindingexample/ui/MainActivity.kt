package com.giridharaspk.databindingexample.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.giridharaspk.databindingexample.R
import com.giridharaspk.databindingexample.data.Repo
import com.giridharaspk.databindingexample.databinding.ActivityMainBinding
import com.giridharaspk.databindingexample.data.model.Employee

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var empAdapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val empList = Repo.getData()

        empAdapter = EmployeeAdapter(this@MainActivity, empList)

        binding.rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()
            adapter = empAdapter
        }

        empAdapter.clickListener = object : EmployeeAdapter.EmployeeClickListener {
            override fun showEmpDetails(emp: Employee) {
                showEmployeeDetails(emp)
            }
        }
    }

    fun showEmployeeDetails(emp: Employee) {
        Log.e("showEmpDetails", emp.toString())
        try {
            val bundle = Bundle()
            bundle.putSerializable("emp", emp)
            val intent = Intent(this@MainActivity, EmployeeDetailsActivity::class.java)
            intent.putExtra("bundle", bundle)
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}