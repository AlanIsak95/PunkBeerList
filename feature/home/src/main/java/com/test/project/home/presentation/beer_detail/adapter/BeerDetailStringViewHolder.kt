package com.test.project.home.presentation.beer_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.project.home.databinding.ItemSimpleStringBinding


class BeerDetailStringViewHolder  private constructor(
    private val binding: ItemSimpleStringBinding
) : RecyclerView.ViewHolder(binding.root) {

    /** */
fun bind(textValue: String) {
    binding.apply {
        itemSimpleStringText.text = textValue
    }
}


    /** */
    companion object {
        /** */
        fun from(parent: ViewGroup): BeerDetailStringViewHolder {
            val layoutInflater = ItemSimpleStringBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return BeerDetailStringViewHolder(layoutInflater)
        }
    }
}
