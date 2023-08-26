package haw.bmaajp.groceriesapp.presentation.common.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import haw.bmaajp.groceriesapp.navigation.screen.Screen
import haw.bmaajp.groceriesapp.presentation.common.card.ProductCard
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_12dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_16dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_174dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_2dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_8dp
import haw.bmaajp.groceriesapp.ui.theme.GilroyFontFamily
import haw.bmaajp.groceriesapp.ui.theme.GrayBorderStroke
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_12sp
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_24sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ListStyleWeek(
    modifier: Modifier = Modifier,
    title: String,
    products: List<ProductItem>,
    navController: NavController,
    onClickToCart: (ProductItem) -> Unit
) {

    val scope = rememberCoroutineScope()
    val state = rememberLazyListState()
    val scrollState = rememberScrollState()
    state.disableScrolling(scope)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()


    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Divider(
                Modifier
                    .height(1.dp)
                    .width(44.dp)
                    .align(Alignment.CenterVertically)
                    .padding(16.dp, 0.dp, 0.dp, 0.dp)
            )

            Text(
                modifier = Modifier.padding(DIMENS_8dp, 0.dp, DIMENS_8dp, 0.dp),
                text = title,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = TEXT_SIZE_24sp,
                color = Color.Black
            )

            Divider(
                Modifier
                    .height(1.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )


        }
        Divider(
            Modifier
                .height(24.dp)
                .width(1.dp)
                .offset(16.dp, (-15).dp)
        )
        LazyRow(
            modifier = Modifier.nestedScroll(rememberNestedScrollInteropConnection())

        ) {
            item {
                Card(
                    shape = RoundedCornerShape(DIMENS_12dp),
                    border = BorderStroke(width = 1.dp, color = GrayBorderStroke),
                    modifier = modifier
                        .padding(DIMENS_12dp)
                        .width(DIMENS_174dp)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.style_week),
                        contentDescription = stringResource(R.string.image_content_empty)
                    )
                }
            }


            items(products) { product ->
                ProductCard(
                    productItem = product,
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
            OutlinedButton(
                modifier = Modifier.padding(DIMENS_8dp, 0.dp, DIMENS_8dp, 0.dp),
                onClick = { },
                border = BorderStroke(1.dp, Color.Black),
                shape = RoundedCornerShape(8), // = 50% percent
                // or shape = CircleShape
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
            ) {
                Text(
                    text = "Shop the style",
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = TEXT_SIZE_24sp,
                    color = Color.Black
                )
            }



            Divider(
                Modifier
                    .height(1.dp)
                    .width(28.dp)
                    .align(Alignment.CenterVertically)

            )
            Divider(
                Modifier
                    .padding(0.dp, 0.dp, 16.dp, 0.dp)
                    .height(24.dp)
                    .width(1.dp)
                    .align(Alignment.Top)



            )

        }

    }


}

fun LazyListState.disableScrolling(scope: CoroutineScope) {
    scope.launch {
        scroll(scrollPriority = MutatePriority.PreventUserInput) {
            // Await indefinitely, blocking scrolls
            awaitCancellation()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListStyleWeekPreview() {
    ListStyleWeek(
        title = "Exclusive Offer",
        products = listOf(
            ProductItem(
                id = 1,
                title = "Organic Bananas",
                description = "",
                image = R.drawable.product10,
                unit = "7pcs, Priceg",
                price = 4.99,
                nutritions = "100gr",
                review = 4.0
            ),
            ProductItem(
                id = 1,
                title = "Organic Bananas",
                description = "",
                image = R.drawable.product10,
                unit = "7pcs, Priceg",
                price = 4.99,
                nutritions = "100gr",
                review = 4.0
            ),
            ProductItem(
                id = 1,
                title = "Organic Bananas",
                description = "",
                image = R.drawable.product10,
                unit = "7pcs, Priceg",
                price = 4.99,
                nutritions = "100gr",
                review = 4.0
            )
        ),
        navController = rememberNavController(),
        onClickToCart = {}
    )
}