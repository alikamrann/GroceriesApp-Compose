package haw.bmaajp.groceriesapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import haw.bmaajp.groceriesapp.domain.model.BrandItem
import haw.bmaajp.groceriesapp.domain.model.DesignerItem
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertProducts(products: List<ProductItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertBrands(brands: List<BrandItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertDesigners(designer: List<DesignerItem>)

    @Query("SELECT * FROM product_table")
    fun getAllProducts(): Flow<List<ProductItem>>

    @Query("SELECT * FROM product_table WHERE id=:productId")
    fun getSelectedProduct(productId: Int): ProductItem

    @Query("SELECT * FROM product_table WHERE isCart=:isCart")
    fun getAllProductCart(isCart: Boolean): Flow<List<ProductItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addCart(productItem: ProductItem)

    @Update
     fun deleteCart(productItem: ProductItem)

    @Update
    fun deleteFavorite(productItem: ProductItem)

    @Query("SELECT * FROM product_table WHERE title LIKE '%' || :query || '%'")
    fun searchProduct(query: String): Flow<List<ProductItem>>

    @Query("SELECT * FROM brand_table limit 6")
    fun getAllBrands(): Flow<List<BrandItem>>

    @Query("SELECT * FROM designer_table limit 4")
    fun getAllDesigner(): Flow<List<DesignerItem>>

}