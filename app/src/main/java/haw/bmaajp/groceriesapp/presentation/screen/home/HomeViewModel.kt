package haw.bmaajp.groceriesapp.presentation.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import haw.bmaajp.groceriesapp.domain.model.BrandItem
import haw.bmaajp.groceriesapp.domain.model.DesignerItem
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import haw.bmaajp.groceriesapp.domain.usecase.UseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _productList = MutableStateFlow<List<ProductItem>>(emptyList())
    val productList = _productList.asStateFlow()


    private val _brandList = MutableStateFlow<List<BrandItem>>(emptyList())
    val brandList = _brandList.asStateFlow()

    private val _designerList = MutableStateFlow<List<DesignerItem>>(emptyList())
    val designerList = _designerList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getAllBrandtUseCase.invoke().collect { value ->
                _brandList.value = value
            }
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getAllProductUseCase.invoke().collect { value ->
                _productList.value = value
            }
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getAllDesignersUseCase.invoke().collect { value ->
                _designerList.value = value
            }
        }
    }


    fun addCart(productItem: ProductItem) = viewModelScope.launch {
        useCases.addCartUseCase.invoke(productItem)
    }

}