package haw.bmaajp.groceriesapp.domain.usecase.savebrandusecase

import haw.bmaajp.groceriesapp.data.repository.Repository
import haw.bmaajp.groceriesapp.domain.model.BrandItem

class InsertBrandsUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(brands: List<BrandItem>) = repository.insertBrands(brands)

}