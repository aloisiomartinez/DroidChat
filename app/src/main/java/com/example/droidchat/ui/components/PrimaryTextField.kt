package com.example.droidchat.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.droidchat.ui.theme.DroidChatTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.droidchat.R
import com.example.droidchat.ui.theme.ColorError
import kotlin.math.sin

@Composable
fun PrimaryTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    @DrawableRes
    leadingIcon: Int? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    errorMessage: String? = null
) {
    Column (
        modifier = modifier
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = placeholder)
            },
            leadingIcon = {
                leadingIcon?.let {
                    Icon(
                        painter = painterResource(id = leadingIcon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            trailingIcon = {
                if (keyboardType == KeyboardType.Password && value.isNotEmpty()) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_visibility_off),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            },
            visualTransformation = if (keyboardType == KeyboardType.Password) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            singleLine = true,
            shape = CircleShape,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
                focusedBorderColor = MaterialTheme.colorScheme.surface,
                unfocusedBorderColor = if (errorMessage != null) {
                    MaterialTheme.colorScheme.error
                } else {
                    MaterialTheme.colorScheme.outline
                },
            )
        )

        errorMessage?.let {
            Text(
                text = "Senha é obrigatória",
                modifier = Modifier.padding(start = 16.dp),
                color = ColorError
            )
        }

    }

}

@Preview
@Composable
private fun PrimaryTextFieldPreview() {
    DroidChatTheme {
        PrimaryTextField(
            "asdasd",
            {},
            leadingIcon = R.drawable.ic_safety,
            keyboardType = KeyboardType.Password
        )
    }
}