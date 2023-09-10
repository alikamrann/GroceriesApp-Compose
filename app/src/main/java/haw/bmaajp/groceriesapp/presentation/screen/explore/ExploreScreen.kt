package haw.bmaajp.groceriesapp.presentation.screen.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.presentation.common.card.ParentCategoryCard
import haw.bmaajp.groceriesapp.presentation.component.SearchViewBar
import haw.bmaajp.groceriesapp.ui.theme.Black
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_10dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_16dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_8dp
import haw.bmaajp.groceriesapp.ui.theme.GilroyFontFamily
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_18sp
import haw.bmaajp.groceriesapp.utils.DataDummy

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier.fillMaxSize()
) {

        Column(
            modifier = Modifier.background(Color.White)

        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = DIMENS_16dp),
                text = stringResource(R.string.find_products),
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = TEXT_SIZE_18sp,
                color = Black
            )

            SearchViewBar(hint = stringResource(id = R.string.search_category))

            LazyColumn(
                modifier = Modifier.padding(top = DIMENS_8dp),
                verticalArrangement = Arrangement.spacedBy(DIMENS_10dp),

                ) {
                items(DataDummy.generateDummyParentCategories()) { parentCategoryItem ->
                    ParentCategoryCard(
                        parentCategoryItem = parentCategoryItem,
                        navController = rememberNavController(),
                        onClickToCart = {})
                }
            }
        }

}


@Preview
@Composable
fun ExploreScreenPreview() {
    ExploreScreen()
}