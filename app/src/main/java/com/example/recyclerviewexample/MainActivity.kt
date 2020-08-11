package com.example.recyclerviewexample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexample.adapter.RecyclerTestAdapter
import com.example.recyclerviewexample.databinding.ActivityMainBinding
import com.example.recyclerviewexample.vo.TestInfoVo

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private var testAdapter : RecyclerTestAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.model = viewModel

        testAdapter = RecyclerTestAdapter()
        binding.testRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = testAdapter
        }

        settingObserver()
        viewModel.updateList()

    }

    private fun settingObserver() {
        viewModel.testList.observe(this,
            Observer<List<TestInfoVo>> { testList ->
                testAdapter!!.setData(testList as ArrayList<TestInfoVo>)
            })

    }
}
