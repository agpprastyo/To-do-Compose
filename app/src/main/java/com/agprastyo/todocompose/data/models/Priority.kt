package com.agprastyo.todocompose.data.models

import androidx.compose.ui.graphics.Color
import com.agprastyo.todocompose.ui.theme.HighPriorityColor
import com.agprastyo.todocompose.ui.theme.LowPriorityColor
import com.agprastyo.todocompose.ui.theme.MediumPriorityColor
import com.agprastyo.todocompose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}