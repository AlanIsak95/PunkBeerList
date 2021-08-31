package com.test.project.home.presentation.favorites.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.test.project.connection.home.data.dataSource.local.models.FavoriteToPresentation

class FavoriteFragmentAdapter(
    private val context: Context)
: ListAdapter<FavoriteToPresentation, FavoriteFragmentViewHolder>(FavoriteDiffUtils()){


    /** */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteFragmentViewHolder =
        FavoriteFragmentViewHolder.from(parent)

    /** */
    override fun onBindViewHolder(holder: FavoriteFragmentViewHolder, position: Int) {
        val checkInDoneDummyModel = getItem(position)
        holder.bind(
            checkInDoneDummyModel,
            context
        )
    }

    /**
     * DiffUtil Class
     */
    internal class FavoriteDiffUtils : DiffUtil.ItemCallback<FavoriteToPresentation>() {
        /** */
        override fun areItemsTheSame(
            oldItem: FavoriteToPresentation,
            newItem: FavoriteToPresentation
        ): Boolean = oldItem == newItem

        /** */
        override fun areContentsTheSame(
            oldItem: FavoriteToPresentation,
            newItem: FavoriteToPresentation
        ): Boolean = oldItem == newItem
    }


}