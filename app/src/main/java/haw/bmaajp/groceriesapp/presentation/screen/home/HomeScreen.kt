package haw.bmaajp.groceriesapp.presentation.screen.home

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import haw.bmaajp.groceriesapp.navigation.screen.Screen
import haw.bmaajp.groceriesapp.presentation.common.card.BrandCard
import haw.bmaajp.groceriesapp.presentation.common.content.Banners
import haw.bmaajp.groceriesapp.presentation.common.content.ListContentProduct
import haw.bmaajp.groceriesapp.presentation.common.content.ListMostPopularProduct
import haw.bmaajp.groceriesapp.presentation.common.content.ListStyleWeek
import haw.bmaajp.groceriesapp.presentation.component.DrawableWrapper
import haw.bmaajp.groceriesapp.presentation.component.SaleCompose
import haw.bmaajp.groceriesapp.presentation.component.SearchViewBar
import haw.bmaajp.groceriesapp.presentation.component.SliderBanner
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_114dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_16dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_24dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_48dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_8dp
import haw.bmaajp.groceriesapp.ui.theme.GilroyFontFamily
import haw.bmaajp.groceriesapp.ui.theme.GrayThirdTextColor
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_10sp
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_12sp
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_24sp
import haw.bmaajp.groceriesapp.utils.showToastShort

@ExperimentalPagerApi
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val mContext = LocalContext.current
    val searchQuery by homeViewModel.searchQuery
    val allProducts by homeViewModel.productList.collectAsState()
    val allBrands by homeViewModel.brandList.collectAsState()
    val title = stringResource(id = R.string.top_brands)
    LazyColumn(
        modifier = Modifier.fillMaxSize(),

        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {

        item {


//            HeaderLocationHome()

            SearchViewBar(
                hint = stringResource(id = R.string.search_store),
                query = searchQuery,
                onValueChange = {
                    if (it.isNotEmpty()) navController.navigate(Screen.Search.route)
                }
            )
        }

        item { SaleCompose() }



        item { SliderBanner() }

        item {
            ListContentProduct(
                title = stringResource(id = R.string.exclusive_offer),
                products = allProducts,
                navController = navController,
                onClickToCart = { productItem ->
                    clickToCart(mContext, productItem, homeViewModel)
                }
            )
        }



        item { Spacer(modifier = Modifier.height(DIMENS_48dp)) }

        item {
            ListStyleWeek(title = stringResource(id = R.string.exclusive_offer),
                products = allProducts,
                navController = navController,
                onClickToCart = { productItem ->
                    clickToCart(mContext, productItem, homeViewModel)
                })
        }


        item {
            Spacer(modifier = Modifier.height(DIMENS_16dp))
        }

        item {
            ListMostPopularProduct(title = stringResource(id = R.string.most_popular_product),
                headerIcon =R.drawable.ic_star_border,
                products = allProducts,
                navController = navController,
                onClickToCart = { productItem ->
                    clickToCart(mContext, productItem, homeViewModel)
                })
        }

        item { Spacer(modifier = Modifier.height(DIMENS_16dp)) }

        item { Banners() }

        item { Spacer(modifier = Modifier.height(DIMENS_16dp)) }

        item {


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = DIMENS_16dp, end = DIMENS_16dp),

                ) {
                Text(
                    text = title,
                    Modifier
                        .align(Alignment.Center)
                        .padding(0.dp, 8.dp, 0.dp, 0.dp),
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = TEXT_SIZE_24sp,
                    color = Color.Gray,

                    )
                Image(
                    painter = painterResource(id = R.drawable.ic_star_border),
                    contentDescription = "ic_star_border",
                    Modifier
                        .size(DIMENS_114dp)
                        .align(Alignment.Center)
                        .alpha(0.2f),

                    )
            }
        }
        items(allBrands.windowed(2, 2, true)) { sublist ->
            Row(Modifier.fillMaxWidth()) {
                sublist.forEach { item ->
                    val paddingEnd: Dp
                    val paddingStart: Dp
                    if (sublist.indexOf(item) % 2 == 0) {
                        paddingEnd = 8.dp;
                        paddingStart = 16.dp;
                    }
                    else{
                        paddingEnd = 16.dp;
                        paddingStart = 8.dp;
                    }

                    BrandCard(
                        modifier = Modifier
                            .fillParentMaxWidth(.5f)
                            .padding(start = paddingStart, end = paddingEnd, top = 16.dp),
                        brandItem = item,
                        navController = navController,
                        onClickToCart = {}
                    )
                }
            }
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth().padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Divider(
                    Modifier
                        .height(1.dp)
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                )
                DrawableWrapper(
                    drawableTop = null,
                    drawableStart = null,
                    drawableBottom = null,
                    drawableEnd = R.drawable.ic_keyboard_arrow_right,
                ) {
                    Text(
                        text = stringResource(id = R.string.see_all), Modifier
                            .align(Alignment.CenterVertically)
                            .padding(4.dp, 0.dp, 4.dp, 0.dp),
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = TEXT_SIZE_10sp,
                        color = Color.Gray
                    )
                }
            }
        }

        item {
            ListMostPopularProduct(title = stringResource(id = R.string.new_product),
                products = allProducts,
                navController = navController,
                headerIcon =R.drawable.ic_new_product,
                onClickToCart = { productItem ->
                    clickToCart(mContext, productItem, homeViewModel)
                })
        }


    }
//            MyScreen()


}


@Composable
fun HeaderLocationHome(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(DIMENS_24dp))

        Icon(
            modifier = Modifier
                .size(DIMENS_24dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.ic_nectar),
            contentDescription = stringResource(id = R.string.logo_app),
            tint = Color.Unspecified
        )

        Spacer(modifier = Modifier.height(DIMENS_8dp))

        Row {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = stringResource(R.string.image_location),
                tint = GrayThirdTextColor
            )
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = stringResource(R.string.sample_country),
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = TEXT_SIZE_12sp,
                color = GrayThirdTextColor
            )
        }
    }
}

fun clickToCart(context: Context, productItem: ProductItem, viewModel: HomeViewModel) {
    context.showToastShort("Success Add To Cart ${productItem.title}")
    viewModel.addCart(productItem.copy(isCart = true))
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HeaderLocationHome()
}