package haw.bmaajp.groceriesapp.data.repository

import haw.bmaajp.groceriesapp.data.local.ProductDatabase
import haw.bmaajp.groceriesapp.domain.model.BrandItem
import haw.bmaajp.groceriesapp.domain.model.DesignerItem
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import haw.bmaajp.groceriesapp.domain.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(
    productDatabase: ProductDatabase
) : LocalDataSource {

    private val productDao = productDatabase.productDao()

    override suspend fun insertProducts(products: List<ProductItem>) =
        productDao.insertProducts(products)

    override suspend fun insertBrands(brands: List<BrandItem>) {
        productDao.insertBrands(brands)
    }

    override suspend fun insertDesigner(designer: List<DesignerItem>) {
        productDao.insertDesigners(designer)
    }

    override fun getAllProduct(): Flow<List<ProductItem>> = productDao.getAllProducts()

    override suspend fun getSelectedProduct(productId: Int): ProductItem =
        productDao.getSelectedProduct(productId = productId)

    override fun getAllProductCart(isCart: Boolean): Flow<List<ProductItem>> =
        productDao.getAllProductCart(isCart)

    override suspend fun addCart(productItem: ProductItem) = productDao.addCart(productItem)

    override suspend fun deleteCart(productItem: ProductItem) {
        productItem.isCart = false
        productDao.deleteCart(productItem)
    }

    override suspend fun deleteFavorite(productItem: ProductItem) {
        productItem.isFavorite = false
        productDao.deleteFavorite(productItem)
    }

    override fun searchProduct(query: String): Flow<List<ProductItem>> =
        productDao.searchProduct(query)

    override fun getAllBrands(): Flow<List<BrandItem>> = productDao.getAllBrands()
    override fun getAllDesigner(): Flow<List<DesignerItem>> = productDao.getAllDesigner()


}