package com.eirrok.core.designsystem.component

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class ButtonType {
    TextButton,
    OutlinedButton,
    DefaultButton
}

@Composable
fun TDLButton(
    onClick: () -> Unit,
    text: String,
    type: ButtonType,
    modifier: Modifier = Modifier) {
    Button(
        shape = buttonShape(type = type),
        colors = buttonColors(type = type),
        onClick = onClick,
        modifier = modifier) {
        Text(text = text)
    }
}

@Composable
private fun buttonShape(type: ButtonType) = when (type) {
    ButtonType.TextButton -> ButtonDefaults.textShape
    ButtonType.OutlinedButton -> ButtonDefaults.outlinedShape
    ButtonType.DefaultButton -> ButtonDefaults.shape
}

@Composable
private fun buttonColors(type: ButtonType) = when (type) {
    ButtonType.TextButton -> ButtonDefaults.textButtonColors()
    ButtonType.OutlinedButton -> ButtonDefaults.outlinedButtonColors()
    ButtonType.DefaultButton -> ButtonDefaults.buttonColors()
}