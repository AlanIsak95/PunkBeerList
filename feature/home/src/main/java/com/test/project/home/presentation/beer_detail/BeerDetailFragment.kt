package com.test.project.home.presentation.beer_detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.test.project.home.databinding.BeerDetailFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerDetailFragment : Fragment() {

    /* */
    private val args: BeerDetailFragmentArgs by navArgs()

    /* */
    private val binding : BeerDetailFragmentBinding
            by lazy { BeerDetailFragmentBinding.inflate(layoutInflater) }

    /* */
    private val beerDetailViewModel: BeerDetailViewModel by viewModel()


    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root


    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolBar()
//        executeService()
        setUpAction()
    }

    /** */
    @SuppressLint("SetTextI18n")
    private fun setUpToolBar() {
        binding.mainDetailTlHeader.apply {
            homeMaterialToolbarMtHeader.setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
            homeMaterialToolbarTvTitle.text = "Detalle Cerveza"
            //homeMaterialToolbarIvFavorites.setOnClickListener(::navigateToFavoriteFragment )
        }
    }

    private fun setUpAction() {
        binding.apply {
            texto.text = args.beer?.name
        }
    }
}