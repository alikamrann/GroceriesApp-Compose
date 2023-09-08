package haw.bmaajp.groceriesapp.domain.usecase.getallbrand

import haw.bmaajp.groceriesapp.data.repository.Repository
import haw.bmaajp.groceriesapp.domain.model.BrandItem
import kotlinx.coroutines.flow.Flow

class GetAllBrandUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Flow<List<BrandItem>> = repository.getAllBrands()

}