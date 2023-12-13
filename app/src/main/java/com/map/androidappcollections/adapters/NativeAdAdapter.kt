
package com.map.androidappcollections.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.map.androidappcollections.databinding.RowNativeAdsBinding
import com.map.androidappcollections.databinding.RowNativeAdsRecyclerDataBinding
import com.map.androidappcollections.utils.Const

class NativeAdAdapter( var dataList: MutableList<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    internal val TYPE_AD = 0
    internal val TYPE_DATA = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_AD -> NativeAdHolder(RowNativeAdsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            TYPE_DATA -> NativeAdDataHolder(RowNativeAdsRecyclerDataBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> NativeAdDataHolder(RowNativeAdsRecyclerDataBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NativeAdHolder -> holder.setData(position, dataList[position] as String)
            is NativeAdDataHolder -> holder.setData(position, dataList[position] as String)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataList[position]) {
            Const.TYPE_NATIVE_AD -> TYPE_AD
            else -> TYPE_DATA
        }
    }

    inner class NativeAdHolder(private val binding: RowNativeAdsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setData(position: Int, data: String) {

        }

    }

    inner class NativeAdDataHolder(private val binding: RowNativeAdsRecyclerDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setData(position: Int, data: String) {
            binding.txtName.text = data

        }

    }


}