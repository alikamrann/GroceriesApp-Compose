package haw.bmaajp.groceriesapp.domain.model

import androidx.compose.ui.graphics.Color

data class CategoryItem(
    val id : Int,
    val title: String,
    val image: Int,
    val background: Color
)
