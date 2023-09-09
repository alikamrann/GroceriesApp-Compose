package haw.bmaajp.groceriesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import haw.bmaajp.groceriesapp.data.local.dao.ProductDao
import haw.bmaajp.groceriesapp.domain.model.BrandItem
import haw.bmaajp.groceriesapp.domain.model.DesignerItem
import haw.bmaajp.groceriesapp.domain.model.ProductItem

@Database(entities = [ProductItem::class,BrandItem::class,DesignerItem::class], version = 4)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

}