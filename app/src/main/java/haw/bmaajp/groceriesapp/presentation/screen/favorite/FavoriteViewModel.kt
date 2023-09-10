package haw.bmaajp.groceriesapp.presentation.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import haw.bmaajp.groceriesapp.domain.usecase.UseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val isFavorite = true

    private val _productFavoriteList = MutableStateFlow<List<ProductItem>>(emptyList())
    val productFavoriteList = _productFavoriteList.asStateFlow()

    init {
        getAllProductFavoriteList()
    }

    private fun getAllProductFavoriteList() {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getAllFavoriteUseCase.invoke(isFavorite).collect { values ->
                _productFavoriteList.value = values
            }
        }
    }

    fun deleteFavorite(productItem: ProductItem) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.deleteFavorite.invoke(productItem)
        }
    }

}