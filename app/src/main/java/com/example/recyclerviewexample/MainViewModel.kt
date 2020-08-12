package com.example.recyclerviewexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewexample.vo.TestInfoVo
import java.util.*

class MainViewModel : ViewModel() {
    private val tempTestList = ArrayList<TestInfoVo>()
    val testList =  MutableLiveData<List<TestInfoVo>>()

    fun updateList() {
        tempTestList.clear()
        tempTestList.add(TestInfoVo("People1","010-1111-1111"))
        tempTestList.add(TestInfoVo("People2","010-2222-2222"))
        tempTestList.add(TestInfoVo("People3","010-3333-3333"))
        testList.postValue(tempTestList)
    }

    var number : Int = 4
    fun addButtonClick() {
        tempTestList.add(TestInfoVo("People${number}","010-9999-9999"))
        number++
        testList.postValue(tempTestList)
    }
}