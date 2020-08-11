package com.example.recyclerviewexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.R
import com.example.recyclerviewexample.databinding.RowTestItemBinding
import com.example.recyclerviewexample.vo.TestInfoVo

class RecyclerTestAdapter() :
    RecyclerView.Adapter<RecyclerTestAdapter.TestViewHolder>() {

    private var items = ArrayList<TestInfoVo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val testViewHolder = DataBindingUtil.inflate<RowTestItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.row_test_item,
            parent,
            false
        )

        return TestViewHolder(testViewHolder)
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        items[position].let {
            holder.binding.data = it
        }
    }

    fun setData(testList: ArrayList<TestInfoVo>) {
        val diffUtil = DiffUtil.calculateDiff(DiffCallback(items, testList))
        this.items.clear()
        this.items.addAll(testList)
        diffUtil.dispatchUpdatesTo(this)
    }

    class TestViewHolder(var binding: RowTestItemBinding) : RecyclerView.ViewHolder(binding.root)

    class DiffCallback(
        private val oldData: ArrayList<TestInfoVo>,
        private val newData: ArrayList<TestInfoVo>
    ) : DiffUtil.Callback() {

        override fun getOldListSize() = oldData.size

        override fun getNewListSize() = newData.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) : Boolean {
            return oldData[oldItemPosition] == newData[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldData[oldItemPosition] == newData[newItemPosition]

    }
}

