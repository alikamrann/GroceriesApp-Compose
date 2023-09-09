package haw.bmaajp.groceriesapp.domain.usecase.getallDesigners

import haw.bmaajp.groceriesapp.data.repository.Repository
import haw.bmaajp.groceriesapp.domain.model.DesignerItem
import kotlinx.coroutines.flow.Flow

class GetAllDesigners(
    private val repository: Repository
) {

    operator fun invoke(): Flow<List<DesignerItem>> = repository.getAllDesigners()

}