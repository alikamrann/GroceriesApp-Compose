package haw.bmaajp.groceriesapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import haw.bmaajp.groceriesapp.utils.Constants

@Entity(tableName = Constants.DESIGNER_DATABASE_TABLE)
data class DesignerItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val description: String,
    val image: Int,
    val logo: Int,
    val unit: String,

)