package haw.bmaajp.groceriesapp.presentation.common.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import haw.bmaajp.groceriesapp.domain.model.DesignerItem
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import haw.bmaajp.groceriesapp.navigation.screen.Screen
import haw.bmaajp.groceriesapp.ui.theme.Black
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_120dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_6dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_8dp
import haw.bmaajp.groceriesapp.ui.theme.GilroyFontFamily
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_16sp

@Composable
fun DigiMagCard(
    modifier: Modifier = Modifier,
    designerItem: DesignerItem,
    navController: NavController,
    onClickToCart: (ProductItem) -> Unit
) {

    Card(
        shape = RoundedCornerShape(0.dp),
        elevation = 0.dp,
        modifier = modifier
            .clickable {
                navController.navigate(Screen.Details.passProductId(productId = designerItem.id))
            }

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()

        ) {
            Box(modifier = Modifier) {
                Image(
                    painter = painterResource(id = designerItem.image),
                    contentDescription = stringResource(R.string.image_product),
                    modifier = Modifier

                        .fillMaxWidth()
                        .height(DIMENS_120dp)
                        .padding(DIMENS_6dp)
                )

            }
            Text(
                modifier = Modifier
                    .background(colorResource(id = R.color.light_gray))
                    .align(Alignment.CenterHorizontally)
                    .padding(
                        start = DIMENS_8dp,
                        end = DIMENS_8dp,
                        top = DIMENS_8dp,
                        bottom = DIMENS_8dp
                    )
                    .wrapContentHeight()
                    .fillMaxWidth(),
                text = designerItem.title,
                fontFamily = GilroyFontFamily,
                fontSize = TEXT_SIZE_16sp,
                fontWeight = FontWeight.SemiBold,
                color = Black,
                maxLines = 1,
                textAlign = TextAlign.Center
            )

        }

    }
}

@Preview
@Composable
fun DigiMagCardPreview() {
    DigiMagCard(
        designerItem = DesignerItem(
            id = 1,
            title = "GRAY",
            description = "",
            image = R.drawable.product10,
            unit = "7pcs, Priceg",
            logo = R.drawable.ic_brightness

        ),
        navController = rememberNavController(),
        onClickToCart = {}
    )
}