package haw.bmaajp.groceriesapp.presentation.common.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.domain.model.BrandItem
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import haw.bmaajp.groceriesapp.presentation.common.card.BrandCard
import haw.bmaajp.groceriesapp.presentation.component.DrawableWrapper
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_114dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_16dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_8dp
import haw.bmaajp.groceriesapp.ui.theme.GilroyFontFamily
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_10sp
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_24sp

@Composable
fun ListTopBrands(
    modifier: Modifier = Modifier,
    title: String,
    brands: List<BrandItem>,
    navController: NavController,
    onClickToCart: (ProductItem) -> Unit
) {
    var text by rememberSaveable { mutableStateOf("See all") }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(0.dp, 0.dp, DIMENS_16dp, DIMENS_8dp)


    )

    {
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
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(brands) { brand ->
                BrandCard(
                    brandItem = brand,
                    navController = navController,
                    onClickToCart = onClickToCart
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
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
}

@Preview(showBackground = true)
@Composable
fun ListTopBrandsPreview() {
    ListTopBrands(
        title = stringResource(R.string.top_brands),
        brands = listOf(
            BrandItem(
                id = 1,
                title = "Organic Bananas",
                description = "",
                image = R.drawable.product1,
                unit = "7pcs, Priceg",

            ),
            BrandItem(
                id = 1,
                title = "Organic Bananas",
                description = "",
                image = R.drawable.product2,
                unit = "7pcs, Priceg",

            ),
            BrandItem(
                id = 1,
                title = "Organic Bananas",
                description = "",
                image = R.drawable.product3,
                unit = "7pcs, Priceg",

            ),
            BrandItem(
                id = 1,
                title = "Organic Bananas",
                description = "",
                image = R.drawable.product4,
                unit = "7pcs, Priceg",

                )
        ),
        navController = rememberNavController(),
        onClickToCart = {}
    )
}