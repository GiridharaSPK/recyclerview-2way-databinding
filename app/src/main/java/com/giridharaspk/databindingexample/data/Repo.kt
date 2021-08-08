package com.giridharaspk.databindingexample.data

import com.giridharaspk.databindingexample.data.model.Employee
import com.giridharaspk.databindingexample.data.model.PhoneNumber

object Repo {
    fun getData(): ArrayList<Employee> {
        val list = ArrayList<Employee>()
        val phList1 = ArrayList<PhoneNumber>()
        phList1.add(PhoneNumber("01", "999911"))
        phList1.add(PhoneNumber("02", "999912"))
        val phList2 = ArrayList<PhoneNumber>()
        phList2.add(PhoneNumber("03", "999921"))
        phList2.add(PhoneNumber("04", "999922"))
        val phList3 = ArrayList<PhoneNumber>()
        phList3.add(PhoneNumber("05", "999931"))
        phList3.add(PhoneNumber("06", "999932"))
        list.add(Employee("Emp1", "123", phList1))
        list.add(Employee("Emp2", "234", phList2))
        list.add(Employee("Emp3", "345", phList3))
        return list
    }
}