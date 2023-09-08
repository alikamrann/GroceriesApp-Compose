package haw.bmaajp.groceriesapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import haw.bmaajp.groceriesapp.utils.Constants

@Entity(tableName = Constants.BRAND_DATABASE_TABLE)
data class BrandItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val description: String,
    val image: Int,
    val unit: String,

)