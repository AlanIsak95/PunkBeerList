package com.test.project.home.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.test.project.connection.home.data.dataSource.local.models.PersonToPresentation
import com.test.project.connection.home.domain.use_case.insert_user.InsertUserUseCaseParams
import com.test.project.connection.home.domain.use_case.login.LoginUseCaseParams
import com.test.project.home.R
import com.test.project.home.databinding.LoginFragmentBinding
import com.test.project.resources.presentation.extensions.toBase64
import com.test.project.resources.presentation.message.snackBar.showSnackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    /* */
    private val binding: LoginFragmentBinding
            by lazy { LoginFragmentBinding.inflate(layoutInflater) }

    /* */
    private val loginViewModel: LoginViewModel by viewModel()

    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root


    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        insertInitialUser()
        setUpAction()
        setUpListeners()
    }

    /** Dummy Data */
    private fun insertInitialUser() {
        lifecycleScope.launch(Dispatchers.IO) {
            loginViewModel.insertUser(
                InsertUserUseCaseParams(
                    name = "InterCam",
                    password = "inter95".toBase64()
                )
            )

            loginViewModel.insertUser(
                InsertUserUseCaseParams(
                    name = "Alan",
                    password = "Alan95".toBase64()
                )
            )

            loginViewModel.insertUser(
                InsertUserUseCaseParams(
                    name = "Admin",
                    password = "root".toBase64()
                )
            )
        }


    }



    /** */
    private fun setUpAction() {
        binding.loginFragmentBtnLogin.setOnClickListener(::validateTILS)
    }

    /** */
    private fun validateTILS(view: View) {
        var name = ""
        var password = ""
        binding.apply {
            name = loginFragmentTilName.editText?.text.toString()
            password = loginFragmentTilPassword.editText?.text.toString()
        }

        when {
            (name.isNotBlank() && password.isNotBlank()) -> {

                showTilError(
                    userErrorTil = false,
                    passwordErrorTil = false
                )
                executeLogin(name, password)

            }

            (name.isBlank() && password.isBlank()) ->
                showTilError(
                    userErrorTil = true,
                    passwordErrorTil = true
                )

            name.isBlank() ->
                showTilError(
                    userErrorTil = true,
                    passwordErrorTil = false
                )

            password.isBlank() ->
                showTilError(
                    userErrorTil = false,
                    passwordErrorTil = true
                )

        }


    }

    /** */
    private fun showTilError(
        userErrorTil: Boolean,
        userTilText: String = "campos vacíos",
        passwordErrorTil: Boolean,
        passwordTilText: String = "campos vacíos"
    ) {

        binding.apply {
            loginFragmentTilName.error = if (userErrorTil) userTilText else null
            loginFragmentTilPassword.error = if (passwordErrorTil) passwordTilText else null
        }

    }

    /** */
    private fun executeLogin(name: String, password: String) {
        lifecycleScope.launch {
            loginViewModel.validateDataForLogin(
                LoginUseCaseParams(
                    name = name,
                    password = password
                )
            ).observe(viewLifecycleOwner, loginResponse())
        }
    }

    /** */
    private fun loginResponse() = Observer<ArrayList<PersonToPresentation?>> {
        try {
            if (it.isNotEmpty())
                if (it.first() != null) {
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                } else {
                    showTilError(
                        userErrorTil = true,
                        passwordErrorTil = true,
                        userTilText = "Validar Usuario",
                        passwordTilText = "Validar Contraseña"
                    )
                }
            else
                showSnackbar("Error")
        } catch (e: Exception) {
            showSnackbar("Error ${e.message}")
        }
    }

    /** */
    private fun setUpListeners() {

        binding.apply {
            loginFragmentTilName.editText?.addTextChangedListener {
                loginFragmentTilName.error = null
            }
            loginFragmentTilPassword.editText?.addTextChangedListener {
                loginFragmentTilPassword.error = null
            }
        }

    }

}