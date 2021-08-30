package com.test.project.home.presentation.login

import androidx.lifecycle.ViewModel
import com.test.project.connection.home.presentation.insert_user.IGetInsertUser
import com.test.project.connection.home.presentation.login.IGetLogin

class LoginViewModel(
    iGetLogin : IGetLogin,
    iGetInsertUser: IGetInsertUser
): ViewModel(),
    IGetLogin by iGetLogin,
    IGetInsertUser by iGetInsertUser