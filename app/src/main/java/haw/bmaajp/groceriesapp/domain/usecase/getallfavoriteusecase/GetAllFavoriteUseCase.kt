package haw.bmaajp.groceriesapp.domain.usecase.getallfavoriteusecase

import haw.bmaajp.groceriesapp.data.repository.Repository
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import kotlinx.coroutines.flow.Flow

class GetAllFavoriteUseCase(
    private val repository: Repository
) {

    operator fun invoke(isFavorite: Boolean): Flow<List<ProductItem>> =
        repository.getAllProductFavorite(isFavorite)

}