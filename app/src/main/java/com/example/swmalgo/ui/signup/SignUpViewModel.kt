package com.example.swmalgo.ui.signup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(

) : ViewModel() {

    companion object {
        val passWordRegex =
            """^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[${'$'}@${'$'}!%*#?&]).{8,15}.${'$'}""".toRegex()
    }
}