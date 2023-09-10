package haw.bmaajp.groceriesapp.domain.usecase.deletefavoriteusecase

import haw.bmaajp.groceriesapp.data.repository.Repository
import haw.bmaajp.groceriesapp.domain.model.ProductItem

class DeleteFavoriteUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(productItem: ProductItem) = repository.deleteFavorite(productItem)

}