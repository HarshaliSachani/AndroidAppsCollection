package com.map.androidappcollections.activities

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.map.androidappcollections.adapters.NativeAdAdapter
import com.map.androidappcollections.base.BaseActivity
import com.map.androidappcollections.databinding.ActivityRecyclerViewWithAdsBinding
import com.map.androidappcollections.utils.Const

/**
 * Created by Harshali.Sachani on 12/13/2023.
 */
class RecyclerViewWithAdsActivity : BaseActivity() {

    private lateinit var binding: ActivityRecyclerViewWithAdsBinding
    private var adapter: NativeAdAdapter? = null
    private var layoutManager: GridLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewWithAdsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /**
         * originalContentList : your data list (from API or local database)
         */
        val originalContentList = ArrayList<Any>()
        val currentListSize = 4 /* size of the list (here for example)*/
        for (i in 0 until currentListSize) {
            originalContentList.add("$i") /*  added dummy data */
        }

        /* Insert AdsView in originalContentList */
        /**
         * Const.native_ad_count : it will be index of first ads placement (index count from 0)
         * if span count is 2 and you want to show ads after every row it will be 2, if you want to show ads after every 2 row value will be 4
         * if span count is 3 and you want to show ads after every row it will be 3, if you want to show ads after every 2 row value will be 6
         */
        if (originalContentList.size > Const.native_ad_count) {
            val nativeAdsSize: Int = originalContentList.size / Const.native_ad_count
            val loopEndPoint = originalContentList.size + nativeAdsSize
            for (i in Const.native_ad_count until loopEndPoint step Const.native_ad_count + 1) {
                originalContentList.add(i, Const.TYPE_NATIVE_AD)
            }
        }

        Log.e(TAG, "onCreate: originalContentList=$originalContentList")

        val spanCount = 2
        layoutManager = GridLayoutManager(this, spanCount)
        adapter = NativeAdAdapter(originalContentList)
        binding.recyclerNativeAds.adapter = adapter

        layoutManager?.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adapter?.getItemViewType(position)) {
                    adapter?.TYPE_AD -> spanCount
                    adapter?.TYPE_DATA -> 1
                    else -> -1
                }
            }
        }

        binding.recyclerNativeAds.layoutManager = layoutManager
    }

}