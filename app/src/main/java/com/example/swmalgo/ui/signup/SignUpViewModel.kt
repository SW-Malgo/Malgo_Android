package com.example.swmalgo.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


data class SignUpUiState(
    val email: String = "",
    val validateCode: String = "",
    val password: String = "",
    val passwordCheck: String = "",
    val keyWord: List<String> = emptyList()
)

@HiltViewModel
class SignUpViewModel @Inject constructor(

) : ViewModel() {

    private val _email = MutableStateFlow("")
    private val _validateCode = MutableStateFlow("")
    private val _password = MutableStateFlow("")
    private val _passwordCheck = MutableStateFlow("")
    private val _keyWord = MutableStateFlow(emptyList<String>())

    val uiState = combine(
        _email, _validateCode, _password, _passwordCheck, _keyWord
    ) { it ->
        SignUpUiState(
            email = it[0] as String,
            validateCode = it[1] as String,
            password = it[2] as String,
            passwordCheck = it[3] as String,
            keyWord = it[4] as List<String>
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), SignUpUiState())

    fun updateEmail(email: String) {
        _email.value = email
    }

    fun updateValidateCode(validateCode: String) {
        _validateCode.value = validateCode
    }

    fun updatePassword(password: String) {
        _password.value = password
    }

    fun updatePasswordCheck(passwordCheck: String) {
        _passwordCheck.value = passwordCheck
    }

    fun addKeyWord(keyWord: String) {
        _keyWord.value = _keyWord.value + keyWord
    }

    fun removeKeyword(keyWord: String) {
        _keyWord.value = _keyWord.value - keyWord
    }

    companion object {
        val passWordRegex =
            """^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[${'$'}@${'$'}!%*#?&]).{8,15}.${'$'}""".toRegex()
    }
}