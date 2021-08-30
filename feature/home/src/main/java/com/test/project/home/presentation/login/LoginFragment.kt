package com.test.project.home.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.test.project.connection.home.data.dataSource.local.models.PersonToPresentation
import com.test.project.connection.home.domain.use_case.insert_user.InsertUserUseCaseParams
import com.test.project.connection.home.domain.use_case.login.LoginUseCaseParams
import com.test.project.home.databinding.LoginFragmentBinding
import com.test.project.resources.presentation.extensions.toBase64
import com.test.project.resources.presentation.message.snackBar.showSnackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    /* */
    private val binding : LoginFragmentBinding
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
    }

    private fun insertInitialUser() {
        lifecycleScope.launch(Dispatchers.IO){
                loginViewModel.insertUser(InsertUserUseCaseParams(
                    name = "Alan",
                    password = "hola123"
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

        if (name.isNotBlank() && password.isNotBlank())
             executeLogin(name,password)
//        else
//            showTilError()

    }

    private fun executeLogin(name: String, password: String) {
        lifecycleScope.launch(){
            loginViewModel.validateDataForLogin(
                LoginUseCaseParams(
                    name = name,
                    password = password
                )
            ).observe(viewLifecycleOwner, loginResponse())
        }
    }

    private fun loginResponse() = Observer<ArrayList<PersonToPresentation?>> {
        try {
            if (it.isNotEmpty())
                if (it.first() != null){
                    showSnackbar("TRUE TRUE")
                }else{
                    showSnackbar("FALSE FALSE")
                }
            else
                showSnackbar("sin error Login False")
        }catch (e : Exception){
            showSnackbar("Error ${e.message}")
        }
    }

}