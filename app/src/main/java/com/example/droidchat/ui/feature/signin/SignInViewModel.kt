package com.example.droidchat.ui.feature.signin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.droidchat.R
import com.example.droidchat.data.network.NetworkDataSource
import com.example.droidchat.data.network.model.AuthRequest
import com.example.droidchat.ui.feature.signup.SignUpFormState
import com.example.droidchat.ui.validator.FormValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val networkDataSource: NetworkDataSource
) : ViewModel() {

    var formState by mutableStateOf(SignInFormState())
        private set



    fun onFormEvent(event: SignInFormEvent) {
        when (event) {
            is SignInFormEvent.EmailChanged -> {
                formState = formState.copy(email = event.email, emailError = null)
            }

            is SignInFormEvent.PasswordChanged -> {
                formState = formState.copy(password = event.password, passwordError = null)
            }

            SignInFormEvent.Submit -> {
                doSignIn()
            }
        }
    }

    private fun doSignIn() {
        //var isFormValid = true

//        if (isValidForm()) {
//            formState = formState.copy(isLoading = true)
//            //Request API
//        }

//        //resetFormErrorState()
//        if (formState.email.isBlank()) {
//            formState = formState.copy(emailError = R.string.error_message_email_invalid)
//            isFormValid = false
//        }
//
//        if (formState.password.isBlank()) {
//            formState = formState.copy(passwordError = R.string.error_message_password_invalid)
//            isFormValid = false
//        }
//
//        if (isFormValid) {
//            formState = formState.copy(isLoading = true)
//        }
    }

//    private fun isValidForm(): Boolean {
//        return !formValidator.validate(formState).also {
//            formState = it
//        }.hasError
//    }

    private fun resetFormErrorState() {
        formState = formState.copy(
            emailError = null,
            passwordError = null
        )
    }
}

