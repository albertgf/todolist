package com.eirrok.core.designsystem.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TDLFilterChip(selected: Boolean,
                  onClick: () -> Unit,
                  label: @Composable () -> Unit,
                  modifier: Modifier = Modifier,
                  enabled: Boolean = true,
                  leadingIcon: @Composable (() -> Unit)? = null,
                  trailingIcon: @Composable (() -> Unit)? = null,
                  shape: Shape = FilterChipDefaults.shape,
                  colors: SelectableChipColors = FilterChipDefaults.filterChipColors(),
                  elevation: SelectableChipElevation? = FilterChipDefaults.filterChipElevation(),
                  border: SelectableChipBorder? = FilterChipDefaults.filterChipBorder(),
                  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    FilterChip(selected, onClick, label, modifier, enabled, leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource)
}