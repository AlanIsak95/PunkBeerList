package com.test.project.home.presentation.favorites

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.test.project.connection.home.data.dataSource.local.models.FavoriteToPresentation
import com.test.project.home.databinding.FavoriteFragmentBinding
import com.test.project.home.presentation.favorites.adapter.FavoriteFragmentAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoriteFragment : Fragment() {

    /* */
    private val binding : FavoriteFragmentBinding
            by lazy { FavoriteFragmentBinding.inflate(layoutInflater) }

    /* */
    private lateinit var favoriteAdapter : FavoriteFragmentAdapter

    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        setUpToolBar()
        executeRoom()
    }

    /** */
    private fun setUpView() {
        favoriteAdapter = FavoriteFragmentAdapter(context = requireContext())
        binding.favoriteFragmentRvBeerContainer.adapter = favoriteAdapter

    }


    /** */
    private fun executeRoom() {
        /* */
        lifecycleScope.launch {
            favoriteViewModel.getAllFavorites().observe(viewLifecycleOwner, getData())
        }
    }

    /** */
    private fun getData() = Observer<ArrayList<FavoriteToPresentation>> {
        favoriteAdapter.submitList(it)
    }

    /** */
    @SuppressLint("SetTextI18n")
    private fun setUpToolBar() {
        binding.beerFavoriteTlHeader.apply {
            homeMaterialToolbarMtHeader.setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
            homeMaterialToolbarTvTitle.text = "Favorite Beers"
            homeMaterialToolbarIvFavorites.visibility = View.GONE
        }
    }


}