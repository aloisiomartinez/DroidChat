package com.example.droidchat.ui.validator

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


interface FormValidator<FormState> {
    fun validate(formState: FormState): FormState
}