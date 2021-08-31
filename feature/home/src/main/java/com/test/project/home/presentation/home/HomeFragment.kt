package com.test.project.home.presentation.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.test.project.connection.home.ServiceStatus
import com.test.project.connection.home.domain.entity.get_beer_list.BeerResponseItem
import com.test.project.connection.home.domain.use_case.get_beer_list.GetBeerListResponseDC
import com.test.project.connection.home.domain.use_case.insert_favorite.InsertFavoriteUseCaseParams
import com.test.project.home.databinding.MainFragmentBinding
import com.test.project.home.presentation.HomeActivity
import com.test.project.home.presentation.home.adapter.HomeFragmentAdapter
import com.test.project.resources.presentation.message.snackBar.showSnackbar
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    /* */
    private val binding :MainFragmentBinding
            by lazy { MainFragmentBinding.inflate(layoutInflater) }

    /* */
    private val homeViewModel: HomeViewModel by viewModel()

    /* */
    private lateinit var homeFragmentAdapter :HomeFragmentAdapter

    /** */
    private lateinit var activityReference : HomeActivity

    private var currentPage = 1
    private var maxPage = 10

    private var userRandomValueList : MutableList<BeerResponseItem?>? = ArrayList()


    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root


    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolBar()
        activityReference = activity as HomeActivity
       if (activityReference.getValue()){
           executeService(currentPage)
           setUpListeners()
       }

    }

    /** */
    private fun setUpListeners() {

        homeFragmentAdapter = HomeFragmentAdapter(
            context = requireContext(),
            onBeerClicked = onBeerClicked,
            onCardClicked = onCardClicked
        )

        binding.mainFragmentRvBeerContainer.adapter = homeFragmentAdapter

        binding.mainFragmentRvBeerContainer.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)){
                    currentPage += 1
                    executeService(currentPage)
                }
            }

        })
    }

    /** */
    @SuppressLint("SetTextI18n")
    private fun setUpToolBar() {
        binding.mainFragmentTlHeader.apply {
            homeMaterialToolbarMtHeader.setNavigationOnClickListener {
                this@HomeFragment.requireActivity().onBackPressed()
            }
            homeMaterialToolbarTvTitle.text = "Beer List"
            homeMaterialToolbarIvFavorites.setOnClickListener(::navigateToFavoriteFragment )
        }
    }

    /** */
    private fun navigateToFavoriteFragment(view: View) {
        //navigate to favorite
    }

    /** */
    private fun setUpAction() {

    }

    /** */
    private fun executeService(page : Int) {
        lifecycleScope.launch {
            homeViewModel.getBeerListByPageAsLiveData(page = page)
                .observe(viewLifecycleOwner, getService())
        }
    }

    /** */
    private fun getService() = Observer<ServiceStatus<String?,GetBeerListResponseDC>> {
        when (it) {
            is ServiceStatus.Loading ->{
                binding.apply {
                    mainFragmentPbProgressIndicator.visibility = View.VISIBLE
                }
            }
            is ServiceStatus.Failed -> {
                binding.apply {
                    mainFragmentRvBeerContainer.visibility = View.GONE
                    mainFragmentPbProgressIndicator.visibility = View.INVISIBLE
                }
                showSnackbar(it.failure.toString())
            }
            is ServiceStatus.Done ->{
                binding.apply {
                    mainFragmentRvBeerContainer.visibility = View.VISIBLE
                    mainFragmentPbProgressIndicator.visibility = View.INVISIBLE
                }
                setUpView(userRandomValue = it.value.listBeer)
            }
        }
    }

    /** */
    @SuppressLint("SetTextI18n")
    private fun setUpView(userRandomValue: List<BeerResponseItem?>?) {

        val oldValue = userRandomValueList?.size?:0

        if (userRandomValue != null) {
            userRandomValueList?.addAll(userRandomValue)
        }

        homeFragmentAdapter.notifyItemRangeInserted(oldValue,userRandomValueList?.size?:0)

        homeFragmentAdapter.submitList(userRandomValueList)
        activityReference.setValue(false)

    }


    /** */
    private val onBeerClicked: (BeerResponseItem)  -> Unit = {

        showSnackbar("Beer ${it.name} has been added")
        lifecycleScope.launch{
            homeViewModel.insertFavorite(InsertFavoriteUseCaseParams(
                id = it.id!!,
                name = it.name?:"",
                contributedBy = it.contributed_by?:"",
                rateValue = 0.0,
                imageUrl = it.image_url?:"",
            ))
        }

    }

    /** */
    private val onCardClicked: (BeerResponseItem)  -> Unit = {


        activityReference.setValue(false)
        val direction = HomeFragmentDirections.actionHomeFragmentToBeerDetailFragment(beer = it)
        findNavController().navigate(direction)

    }


}
