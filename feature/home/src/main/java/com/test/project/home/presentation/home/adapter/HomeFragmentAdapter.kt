package com.test.project.home.presentation.home.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.test.project.connection.home.domain.entity.get_beer_list.BeerResponseItem

class HomeFragmentAdapter(
    private val context: Context,
    private val onBeerClicked: (BeerResponseItem) -> Unit
) : ListAdapter<BeerResponseItem, HomeFragmentViewHolder>(HomeFragmentDiffUtil()) {

    /** */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFragmentViewHolder =
        HomeFragmentViewHolder.from(parent)

    /** */
    override fun onBindViewHolder(holder: HomeFragmentViewHolder, position: Int) {
        val checkInDoneDummyModel = getItem(position)
        holder.bind(
            beerResponseItem = checkInDoneDummyModel,
            context = context,
            onBeerClicked = onBeerClicked
        )
    }


    /**
     * DiffUtil Class
     */
    internal class HomeFragmentDiffUtil : DiffUtil.ItemCallback<BeerResponseItem>() {
        /** */
        override fun areItemsTheSame(
            oldItem: BeerResponseItem,
            newItem: BeerResponseItem
        ): Boolean = oldItem == newItem

        /** */
        override fun areContentsTheSame(
            oldItem: BeerResponseItem,
            newItem: BeerResponseItem
        ): Boolean = oldItem == newItem
    }

}