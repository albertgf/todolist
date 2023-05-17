package com.eirrok.core.designsystem.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FloatingAddButton(onClick: () -> Unit,
                      modifier: Modifier = Modifier,
                      shape: Shape = FloatingActionButtonDefaults.shape,
                      containerColor: Color = FloatingActionButtonDefaults.containerColor,
                      contentColor: Color = contentColorFor(containerColor),
                      elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
                      interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },) {
    FloatingActionButton(onClick = onClick,
        modifier = modifier,
        shape = shape,
        containerColor = containerColor,
        contentColor = contentColor,
        elevation = elevation,
        interactionSource = interactionSource,)
    {
        Icon(Icons.Filled.Add, contentDescription = "Add task")
    }
}

@Preview
@Composable
fun FloatingAddButtonPreview() {
    FloatingAddButton(onClick = { /*TODO*/ })
}