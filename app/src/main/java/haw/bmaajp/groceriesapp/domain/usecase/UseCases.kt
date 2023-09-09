package haw.bmaajp.groceriesapp.domain.usecase

import haw.bmaajp.groceriesapp.domain.usecase.addcartusecase.AddCartUseCase
import haw.bmaajp.groceriesapp.domain.usecase.deletecartusecase.DeleteCartUseCase
import haw.bmaajp.groceriesapp.domain.usecase.getallDesigners.GetAllDesigners
import haw.bmaajp.groceriesapp.domain.usecase.getallbrand.GetAllBrandUseCase
import haw.bmaajp.groceriesapp.domain.usecase.getallcartusecase.GetAllCartUseCase
import haw.bmaajp.groceriesapp.domain.usecase.getallproduct.GetAllProductUseCase
import haw.bmaajp.groceriesapp.domain.usecase.getselectedproduct.GetSelectedProductUseCase
import haw.bmaajp.groceriesapp.domain.usecase.readonboarding.ReadOnBoardingUseCase
import haw.bmaajp.groceriesapp.domain.usecase.savebrandusecase.InsertBrandsUseCase
import haw.bmaajp.groceriesapp.domain.usecase.savedesignerusecase.InsertDesignersUseCase
import haw.bmaajp.groceriesapp.domain.usecase.saveonboarding.SaveOnBoardingUseCase
import haw.bmaajp.groceriesapp.domain.usecase.saveproductusecase.InsertProductsUseCase
import haw.bmaajp.groceriesapp.domain.usecase.searchproductusecase.SearchProductUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val insertProductsUseCase: InsertProductsUseCase,
    val insertBrandsUseCase: InsertBrandsUseCase,
    val insertDesignersUseCase: InsertDesignersUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getSelectedProductUseCase: GetSelectedProductUseCase,
    val getAllProductUseCase: GetAllProductUseCase,
    val getAllBrandtUseCase: GetAllBrandUseCase,
    val getAllDesignersUseCase: GetAllDesigners,
    val getAllCartUseCase: GetAllCartUseCase,
    val addCartUseCase: AddCartUseCase,
    val deleteCart: DeleteCartUseCase,
    val searchProductUseCase: SearchProductUseCase
)