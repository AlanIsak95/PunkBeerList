package com.test.project.home.presentation.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.test.project.connection.home.domain.entity.get_beer_list.BeerResponseItem
import com.test.project.home.databinding.ItemHomeFragmentViewHolderBinding

class HomeFragmentViewHolder private constructor(
    private val binding: ItemHomeFragmentViewHolderBinding
) : RecyclerView.ViewHolder(binding.root) {

    /** */
    fun bind(
        beerResponseItem: BeerResponseItem,
        context: Context,
        onBeerClicked: (BeerResponseItem) -> Unit,
        onCardClicked: (BeerResponseItem) -> Unit
    ) {
        binding.apply {
            itemHomeFragmentViewHolderTvTitle.text = beerResponseItem.name
            itemHomeFragmentViewHolderTvSubtitle.text = beerResponseItem.contributed_by
            Picasso.with(context).load(beerResponseItem.image_url).into(itemHomeFragmentViewHolderIvBeer)
            itemHomeFragmentViewHolderIvFavorite.setOnClickListener {
                clickRow(onBeerClicked,beerResponseItem)
            }
            itemHomeFragmentViewHolderCvContainer.setOnClickListener { onCardClicked(beerResponseItem) }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun clickRow(
        onBeerClicked: (BeerResponseItem) -> Unit,
        beerResponseItem: BeerResponseItem
    ) {
        binding.itemHomeFragmentViewHolderTvTitle.text= "${beerResponseItem.name} (Favorito)"
        onBeerClicked(beerResponseItem)
    }

    /** */
    companion object {
        /** */
        fun from(parent: ViewGroup): HomeFragmentViewHolder {
            val layoutInflater = ItemHomeFragmentViewHolderBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return HomeFragmentViewHolder(layoutInflater)
        }
    }
}