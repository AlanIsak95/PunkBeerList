package com.test.project.home.presentation.favorites.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.test.project.connection.home.data.dataSource.local.models.FavoriteToPresentation
import com.test.project.home.databinding.ItemFavoriteFragmentBinding

class FavoriteFragmentViewHolder   private constructor(
    private val binding: ItemFavoriteFragmentBinding
) : RecyclerView.ViewHolder(binding.root) {

    /** */
    fun bind(
        favoriteItem: FavoriteToPresentation,
        context: Context
    ) {
        binding.apply {

            itemFavoriteFragmentViewHolderTvTitle.text = favoriteItem.name
            itemFavoriteFragmentViewHolderTvSubtitle.text = favoriteItem.contributedBy
            Picasso.with(context).load(favoriteItem.imageURL).into(itemFavoriteFragmentViewHolderIvImage)

        }
    }


    /** */
    companion object {
        /** */
        fun from(parent: ViewGroup): FavoriteFragmentViewHolder {
            val layoutInflater = ItemFavoriteFragmentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return FavoriteFragmentViewHolder(layoutInflater)
        }
    }
}
