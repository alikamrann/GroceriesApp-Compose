package haw.bmaajp.groceriesapp.data.repository

import haw.bmaajp.groceriesapp.domain.model.BrandItem
import haw.bmaajp.groceriesapp.domain.model.DesignerItem
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import haw.bmaajp.groceriesapp.domain.repository.LocalDataSource
import haw.bmaajp.groceriesapp.domain.repository.OnBoardingOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: OnBoardingOperations,
    private val localDataSource: LocalDataSource
) {

    suspend fun saveOnBoardingState(isCompleted: Boolean) {
        dataStore.saveOnBoardingState(isCompleted = isCompleted)
    }

    fun readOnBoardingState(): Flow<Boolean> = dataStore.readOnBoardingState()

    suspend fun insertProducts(products: List<ProductItem>) =
        localDataSource.insertProducts(products)

    suspend fun insertBrands(brands: List<BrandItem>) =
        localDataSource.insertBrands(brands)

    suspend fun insertDesigners(designers: List<DesignerItem>) =
        localDataSource.insertDesigner(designers)

    fun getAllProduct(): Flow<List<ProductItem>> = localDataSource.getAllProduct()

    suspend fun getSelectedProduct(productId: Int): ProductItem =
        localDataSource.getSelectedProduct(productId = productId)

    fun getAllProductCart(isCart: Boolean): Flow<List<ProductItem>> =
        localDataSource.getAllProductCart(isCart)

    suspend fun addCart(productItem: ProductItem) = localDataSource.addCart(productItem)

    suspend fun deleteCart(productItem: ProductItem) = localDataSource.deleteCart(productItem)

    fun searchProduct(query: String): Flow<List<ProductItem>> = localDataSource.searchProduct(query)
    fun getAllBrands(): Flow<List<BrandItem>> =
        localDataSource.getAllBrands()


    fun getAllDesigners(): Flow<List<DesignerItem>> =
        localDataSource.getAllDesigner()


}