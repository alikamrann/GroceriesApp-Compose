package haw.bmaajp.groceriesapp.presentation.common.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
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
import haw.bmaajp.groceriesapp.domain.model.CategoryItem
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import haw.bmaajp.groceriesapp.presentation.common.card.MostPopularCategoryCard
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_114dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_16dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_8dp
import haw.bmaajp.groceriesapp.ui.theme.GilroyFontFamily
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_24sp
import haw.bmaajp.groceriesapp.utils.DataDummy

@Composable
fun LisPopularCategories(
    modifier: Modifier = Modifier,
    title: String,
    headerIcon:Int,
    categories: List<CategoryItem>,
    navController: NavController,
    onClickToCart: (ProductItem) -> Unit
) {
    var text by rememberSaveable { mutableStateOf("See all") }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(0.dp, 0.dp, DIMENS_16dp, DIMENS_8dp)


    ) {
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
                painter = painterResource(id = headerIcon),
                contentDescription = "ic_star_border",
                Modifier
                    .size(DIMENS_114dp)
                    .align(Alignment.Center)
                    .alpha(0.2f),

                )
        }
        LazyHorizontalGrid(
            verticalArrangement = Arrangement.spacedBy(space = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(space = 16.dp),
            contentPadding = PaddingValues(DIMENS_8dp),
            modifier = Modifier.height(350.dp),
            rows = GridCells.Fixed(count = 2),
        ) {
            items(categories.size) { index ->
                    MostPopularCategoryCard(
                        modifier = Modifier.wrapContentHeight(),
                        categoryItem = categories[index],
                        navController = navController,
                        onClickToCart = {}
                    )

            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth().padding(top = DIMENS_16dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Divider(
                Modifier
                    .height(1.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun LisPopularCategoriesPreview() {
    LisPopularCategories(
        title = stringResource(id = R.string.most_popular_categories),
        headerIcon =R.drawable.ic_category,
        categories = DataDummy.generateDummyCategories(),
        navController = rememberNavController(),
        onClickToCart = {}
    )
}