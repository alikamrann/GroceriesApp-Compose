package haw.bmaajp.groceriesapp.presentation.common.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.domain.model.CategoryItem
import haw.bmaajp.groceriesapp.domain.model.ParentCategoryItem
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import haw.bmaajp.groceriesapp.navigation.screen.Screen
import haw.bmaajp.groceriesapp.ui.theme.Black
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_16dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_20dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_24dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_2dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_48dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_64dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_8dp
import haw.bmaajp.groceriesapp.ui.theme.GilroyFontFamily
import haw.bmaajp.groceriesapp.ui.theme.GrayBorderStroke
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_16sp

@Composable
fun ParentCategoryCard(
    modifier: Modifier = Modifier,
    parentCategoryItem: ParentCategoryItem,
    navController: NavController,
    onClickToCart: (ProductItem) -> Unit,

    ) {

    Card(border = BorderStroke(0.dp, color = GrayBorderStroke),
        elevation = 0.dp,
        shape = RoundedCornerShape(0.dp),
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate(Screen.Details.passProductId(productId = parentCategoryItem.categoryItem.id))
            }) {
        Column {
            Box(
                modifier = Modifier.fillMaxWidth(),

                ) {
                Image(
                    painterResource(R.drawable.category_test),
                    contentDescription = stringResource(R.string.image_product),
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth

                )
                Box(
                    modifier = Modifier
                        .padding(end = DIMENS_20dp)
                        .wrapContentWidth()
                        .height(DIMENS_64dp)
                        .background(color = Color.White)
                        .align(Alignment.BottomEnd)
                        .padding(start = DIMENS_16dp, end = DIMENS_16dp)
                ) {
                    Text(
                        text = stringResource(R.string.mens),
                        fontFamily = GilroyFontFamily,
                        fontSize = TEXT_SIZE_16sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Black,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                Box(
                    modifier = Modifier
                        .padding(start = DIMENS_20dp, bottom = DIMENS_16dp)
                        .width(DIMENS_48dp)
                        .height(DIMENS_48dp)
                        .background(color = Color.White)
                        .align(Alignment.BottomStart)
                        .padding(start = DIMENS_8dp, end = DIMENS_8dp)
                ) {
                    Icon(
                        Icons.Filled.ArrowForward,
                        contentDescription = "ArrowForward",
                        tint = Color.Gray,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .fillMaxSize()
                    )
                }
            }
            Spacer(
                modifier = Modifier
                    .padding(end = DIMENS_8dp, start = DIMENS_8dp)
                    .height(DIMENS_16dp)
                    .fillMaxWidth()
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(DIMENS_2dp),
                contentPadding = PaddingValues(DIMENS_8dp),
                modifier = Modifier.padding(start = DIMENS_8dp)
            ) {
                items(parentCategoryItem.categories) { category ->
                    ChildCategoryCard(
                        categoryItem = category,
                        navController = navController,
                        onClickToCart = onClickToCart
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .height(DIMENS_24dp)
                    .fillMaxWidth()
            )
            Divider(
                Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .padding(start = DIMENS_20dp, end = DIMENS_20dp)
                    .background(color = colorResource(id = R.color.light_gray))

            )
            Spacer(
                modifier = Modifier
                    .padding(end = DIMENS_8dp, start = DIMENS_8dp)
                    .height(DIMENS_16dp)
                    .fillMaxWidth()
            )

        }
    }
}

@Preview
@Composable
fun ParentCategoryCardPreview() {
    ParentCategoryCard(parentCategoryItem = ParentCategoryItem(
        categoryItem = CategoryItem(
            id = 1,
            title = "Organic Bananas",
            image = R.drawable.category_test,
            background = Color.White
        ),
        categories = listOf(
            CategoryItem(
                id = 1, title = "Pants", image = R.drawable.pans, background = Color.White
            ),
            CategoryItem(
                id = 1, title = "Pants", image = R.drawable.pans, background = Color.White
            ),
            CategoryItem(
                id = 1, title = "Pants", image = R.drawable.pans, background = Color.White
            ),
            CategoryItem(
                id = 1, title = "Pants", image = R.drawable.pans, background = Color.White
            ),
            CategoryItem(
                id = 1, title = "Pants", image = R.drawable.pans, background = Color.White
            ),
            CategoryItem(
                id = 1, title = "Pants", image = R.drawable.pans, background = Color.White
            ),
        )
    ), navController = rememberNavController(), onClickToCart = {})
}