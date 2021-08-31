package com.test.project.home.presentation.beer_detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.test.project.home.databinding.BeerDetailFragmentBinding
import com.test.project.home.presentation.beer_detail.adapter.BeerDetailStringAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerDetailFragment : Fragment() {

    /* */
    private val args: BeerDetailFragmentArgs by navArgs()

    /* */
    private val binding : BeerDetailFragmentBinding
            by lazy { BeerDetailFragmentBinding.inflate(layoutInflater) }

    /* */
    private val beerDetailViewModel: BeerDetailViewModel by viewModel()

    private lateinit var pairingAdapter : BeerDetailStringAdapter

    private lateinit var hopsAdapter : BeerDetailStringAdapter

    private lateinit var maltAdapter : BeerDetailStringAdapter


    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root


    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolBar()
        setUpAdapters()
        setUpView()
    }


    /** */
    @SuppressLint("SetTextI18n")
    private fun setUpToolBar() {
        binding.beerDetailTlHeader.apply {
            homeMaterialToolbarMtHeader.setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
            homeMaterialToolbarTvTitle.text = "Beer Detail"
        }
    }

    /** */
    private fun setUpAdapters() {

         pairingAdapter = BeerDetailStringAdapter()
         hopsAdapter = BeerDetailStringAdapter()
         maltAdapter = BeerDetailStringAdapter()

    }

    /** */
    @SuppressLint("SetTextI18n")
    private fun setUpView() {
        binding.apply {
            args.beer?.let{

                Picasso.with(context).load(it.image_url).into(beerDetailIvImage)
                beerDetailTvTitle.text = it.name
                beerDetailTvYeastValue.text = it.ingredients?.yeast
                beerDetailTvBeerLtsValue.text = "${it.volume?.value} ${it.volume?.unit} "
                beerDetailTvAbvValue.text = it.abv.toString()
                beerDetailTvIbuValue.text = it.ibu.toString()
                beerDetailTvOgValue.text = it.target_og.toString()
                beerDetailTvFgValue.text = it.target_fg.toString()
                beerDetailTvDescriptionTitle.text = it.tagline
                beerDetailTvDescriptionValue.text = "First Brewed: ${it.first_brewed}"
                beerDetailTvTipsValue.text = it.brewers_tips

                beerDetailRvPairingRecycler.adapter = pairingAdapter
                beerDetailRvHopsRecycler.adapter = hopsAdapter
                beerDetailRvMaltRecycler.adapter = maltAdapter

                pairingAdapter.submitList(it.food_pairing)
                hopsAdapter.submitList(it.ingredients?.toHopStringList())
                maltAdapter.submitList(it.ingredients?.toMaltStringList())

            }
        }
    }
}