package haw.bmaajp.groceriesapp.domain.repository

import haw.bmaajp.groceriesapp.domain.model.BrandItem
import haw.bmaajp.groceriesapp.domain.model.DesignerItem
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun insertProducts(products: List<ProductItem>)

    suspend fun insertBrands(brands: List<BrandItem>)

    suspend fun insertDesigner(designer: List<DesignerItem>)

    fun getAllProduct(): Flow<List<ProductItem>>
    suspend fun getSelectedProduct(productId: Int): ProductItem
    fun getAllProductCart(isCart: Boolean): Flow<List<ProductItem>>
    suspend fun addCart(productItem: ProductItem)
    suspend fun deleteCart(productItem: ProductItem)
    suspend fun deleteFavorite(productItem: ProductItem)
    fun searchProduct(query: String): Flow<List<ProductItem>>
    fun getAllBrands(): Flow<List<BrandItem>>


    fun getAllDesigner(): Flow<List<DesignerItem>>
}