package com.test.project.home.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.squareup.picasso.Picasso
import com.test.project.connection.home.ServiceStatus
import com.test.project.connection.home.domain.entity.get_random_user.GetRandomUserResponse
import com.test.project.connection.home.domain.use_case.get_random_user.GetRandomUserResponseDC
import com.test.project.home.R
import com.test.project.home.databinding.MainFragmentBinding
import com.test.project.resources.presentation.message.snackBar.showSnackbar
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    /* */
    private val binding :MainFragmentBinding
            by lazy { MainFragmentBinding.inflate(layoutInflater) }


    /* */
    private val homeViewModel: HomeViewModel by viewModel()


    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root


    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAction()
    }

    /** */
    private fun setUpAction() {
        binding.mainFragmentBtTryMe.setOnClickListener {
            executeService()
        }
    }

    /** */
    private fun executeService() {
        lifecycleScope.launch {
            homeViewModel.getRandomUserAsLiveData()
                .observe(viewLifecycleOwner, getService())
        }
    }

    /** */
    private fun getService() = Observer<ServiceStatus<String?,GetRandomUserResponseDC>> {
        when (it) {
            is ServiceStatus.Loading ->{
                binding.apply {
                    mainFragmentCvGeneralContainer.visibility = View.GONE
                    mainFragmentBtTryMe.isEnabled = false
                    mainFragmentPbProgressIndicator.visibility = View.VISIBLE
                }

            }
            is ServiceStatus.Failed -> {
                binding.apply {
                    mainFragmentCvGeneralContainer.visibility = View.GONE
                    mainFragmentBtTryMe.isEnabled = true
                    mainFragmentPbProgressIndicator.visibility = View.INVISIBLE
                }
                showSnackbar(it.failure.toString())
            }
            is ServiceStatus.Done ->{
                binding.apply {
                    mainFragmentCvGeneralContainer.visibility = View.VISIBLE
                    mainFragmentBtTryMe.isEnabled = true
                    mainFragmentPbProgressIndicator.visibility = View.INVISIBLE
                }
                setUpView(userRandomValue = it.value.user)
            }
        }

    }

    /** */
    @SuppressLint("SetTextI18n")
    private fun setUpView(userRandomValue: GetRandomUserResponse?) {

        var name = ""
        var gender = ""
        var age = ""
        var street: String
        var city: String
        var country: String
        var postCode: String
        var location = ""
        var email = ""
        var phone = ""
        var url = ""

        userRandomValue?.results?.first()?.let { result ->
            name        = " ${result.name?.title} ${result.name?.first} ${result.name?.last}"
            gender      = result.gender
            age         = result.dob?.age.toString()
            street      ="${result.location?.street?.number}, ${result.location?.street?.name}"
            city        = result.location?.city?:"unknown"
            country     = result.location?.country?:"unknown"
            postCode    = result.location?.postcode.toString()
            location    = "$street, $city, $country, $postCode"
            email       = result.email
            phone       = result.phone
            url         = result.picture?.large?:""

        }

        binding.apply {

            Picasso.with(context).load(url).into(mainFragmentIvHeaderIcon)

            mainFragmentTvHeaderName.text            = "${getString(R.string.name)} $name"
            mainFragmentTvHeaderGender.text          = "${getString(R.string.gender)} $gender"
            mainFragmentTvHeaderAge.text             = "${getString(R.string.age)} $age"
            mainFragmentTvHeaderLocationDetail.text  =  location
            mainFragmentTvHeaderEmail.text           = "${getString(R.string.email)} $email"
            mainFragmentTvHeaderPhone.text           = "${getString(R.string.phone)} $phone"

        }

    }

}
