package com.test.project.home.presentation.beer_detail.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil

class BeerDetailStringAdapter :ListAdapter<String, BeerDetailStringViewHolder>(BeerDetailDiffUtils()){


    /** */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerDetailStringViewHolder =
        BeerDetailStringViewHolder.from(parent)

    /** */
    override fun onBindViewHolder(holder: BeerDetailStringViewHolder, position: Int) {
        val checkInDoneDummyModel = getItem(position)
        holder.bind(checkInDoneDummyModel)
    }

    /**
     * DiffUtil Class
     */
    internal class BeerDetailDiffUtils : DiffUtil.ItemCallback<String>() {
        /** */
        override fun areItemsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean = oldItem == newItem

        /** */
        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean = oldItem == newItem
    }

}