package haw.bmaajp.groceriesapp.domain.usecase.savedesignerusecase

import haw.bmaajp.groceriesapp.data.repository.Repository
import haw.bmaajp.groceriesapp.domain.model.DesignerItem

class InsertDesignersUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(designers: List<DesignerItem>) = repository.insertDesigners(designers)

}