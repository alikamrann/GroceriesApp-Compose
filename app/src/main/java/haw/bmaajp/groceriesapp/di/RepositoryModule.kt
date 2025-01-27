package haw.bmaajp.groceriesapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import haw.bmaajp.groceriesapp.data.repository.OnBoardingOperationImpl
import haw.bmaajp.groceriesapp.data.repository.Repository
import haw.bmaajp.groceriesapp.domain.repository.OnBoardingOperations
import haw.bmaajp.groceriesapp.domain.usecase.UseCases
import haw.bmaajp.groceriesapp.domain.usecase.addcartusecase.AddCartUseCase
import haw.bmaajp.groceriesapp.domain.usecase.deletecartusecase.DeleteCartUseCase
import haw.bmaajp.groceriesapp.domain.usecase.deletefavoriteusecase.DeleteFavoriteUseCase
import haw.bmaajp.groceriesapp.domain.usecase.getallDesigners.GetAllDesigners
import haw.bmaajp.groceriesapp.domain.usecase.getallbrand.GetAllBrandUseCase
import haw.bmaajp.groceriesapp.domain.usecase.getallcartusecase.GetAllCartUseCase
import haw.bmaajp.groceriesapp.domain.usecase.getallfavoriteusecase.GetAllFavoriteUseCase
import haw.bmaajp.groceriesapp.domain.usecase.getallproduct.GetAllProductUseCase
import haw.bmaajp.groceriesapp.domain.usecase.getselectedproduct.GetSelectedProductUseCase
import haw.bmaajp.groceriesapp.domain.usecase.readonboarding.ReadOnBoardingUseCase
import haw.bmaajp.groceriesapp.domain.usecase.savebrandusecase.InsertBrandsUseCase
import haw.bmaajp.groceriesapp.domain.usecase.savedesignerusecase.InsertDesignersUseCase
import haw.bmaajp.groceriesapp.domain.usecase.saveonboarding.SaveOnBoardingUseCase
import haw.bmaajp.groceriesapp.domain.usecase.saveproductusecase.InsertProductsUseCase
import haw.bmaajp.groceriesapp.domain.usecase.searchproductusecase.SearchProductUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperation(
        @ApplicationContext context: Context
    ): OnBoardingOperations = OnBoardingOperationImpl(context = context)

    @Provides
    @Singleton
    fun provideUseCase(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            insertProductsUseCase = InsertProductsUseCase(repository),
            insertBrandsUseCase = InsertBrandsUseCase(repository),
            insertDesignersUseCase = InsertDesignersUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getSelectedProductUseCase = GetSelectedProductUseCase(repository),
            getAllProductUseCase = GetAllProductUseCase(repository),
            getAllBrandtUseCase =  GetAllBrandUseCase(repository),
            getAllDesignersUseCase = GetAllDesigners(repository),
            getAllCartUseCase = GetAllCartUseCase(repository),
            getAllFavoriteUseCase = GetAllFavoriteUseCase(repository),
            addCartUseCase = AddCartUseCase(repository),
            deleteCart = DeleteCartUseCase(repository),
            deleteFavorite = DeleteFavoriteUseCase(repository),
            searchProductUseCase = SearchProductUseCase(repository),


        )
    }

}