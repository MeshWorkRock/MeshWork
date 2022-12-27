package com.example.meshworkapp.shared.dataclass

import androidx.compose.ui.graphics.painter.Painter

data class UserInfoDataClass(
    val name: String,
    val id: String,
    val profilePhoto: Painter
)
