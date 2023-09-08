package haw.bmaajp.groceriesapp.presentation.common.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.domain.model.BrandItem
import haw.bmaajp.groceriesapp.domain.model.ProductItem
import haw.bmaajp.groceriesapp.navigation.screen.Screen
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_120dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_6dp

@Composable
fun BrandCard(
    modifier: Modifier = Modifier,
    brandItem: BrandItem,
    navController: NavController,
    onClickToCart: (ProductItem) -> Unit
) {

    Card(
    shape = RoundedCornerShape(0.dp),
    modifier = modifier
        .clickable {
            navController.navigate(Screen.Details.passProductId(productId = brandItem.id))
        }

) {
    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Image(
            painter = painterResource(id = brandItem.image),
            contentDescription = stringResource(R.string.image_product),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(DIMENS_120dp)
                .padding(DIMENS_6dp)
        )




        }

    }
}

@Preview
@Composable
fun BrandCardPreview(){
    BrandCard(
        brandItem = BrandItem(
            id = 1,
            title = "Organic Bananas",
            description = "",
            image = R.drawable.product10,
            unit = "7pcs, Priceg",

        ),
        navController = rememberNavController(),
        onClickToCart = {}
    )
}