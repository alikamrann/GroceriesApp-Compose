package haw.bmaajp.groceriesapp.presentation.common.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.domain.model.CategoryItem
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import haw.bmaajp.groceriesapp.navigation.screen.Screen
import haw.bmaajp.groceriesapp.ui.theme.Black
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_16dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_8dp
import haw.bmaajp.groceriesapp.ui.theme.GilroyFontFamily
import haw.bmaajp.groceriesapp.ui.theme.GrayBorderStroke
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_12sp

@Composable
fun ChildCategoryCard(
    modifier: Modifier = Modifier,
    categoryItem: CategoryItem,
    navController: NavController,
    onClickToCart: (ProductItem) -> Unit
) {
    Card(
        elevation = 0.dp,
        modifier = modifier
            .width(144.dp)
            .clickable {
                navController.navigate(Screen.Details.passProductId(productId = categoryItem.id))
            },

        border = BorderStroke(0.dp, color = GrayBorderStroke),
        shape = RoundedCornerShape(0.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = categoryItem.image),
                contentDescription = stringResource(R.string.image_product),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(144.dp),
                contentScale = ContentScale.FillHeight
            )

            Spacer(
                modifier = Modifier
                    .background(
                        color = colorResource(id = R.color.light_gray)
                    )
                    .height(DIMENS_8dp)
                    .fillMaxWidth()
            )

            Text(
                maxLines = 1,
                text = categoryItem.title,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Bold,
                color = Black,
                fontSize = TEXT_SIZE_12sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(color = colorResource(id = R.color.light_gray))
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(end = DIMENS_16dp, start = DIMENS_16dp)

            )
            Spacer(
                modifier = Modifier
                    .background(
                        color = colorResource(id = R.color.light_gray)
                    )
                    .height(DIMENS_8dp)
                    .fillMaxWidth()
            )


        }
    }
}

@Preview
@Composable
fun ChildCategoryCardPreview() {
    ChildCategoryCard(
        categoryItem = CategoryItem(
            id = 1,
            title = "Menswear",
            image = R.drawable.style_image,
            background = Color.White,
        ),
        navController = rememberNavController(),
        onClickToCart = {}
    )
}