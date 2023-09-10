package haw.bmaajp.groceriesapp.presentation.common.content

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
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.ui.theme.Black
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_16dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_248dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_24dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_32dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_64dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_8dp
import haw.bmaajp.groceriesapp.ui.theme.GilroyFontFamily
import haw.bmaajp.groceriesapp.ui.theme.GrayBorderStroke
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_12sp
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_16sp
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_18sp

@Composable
fun EmptyCartContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(id = R.drawable.empty_cart),
            contentDescription = stringResource(R.string.image_content_empty)
        )

        Spacer(modifier = Modifier.height(DIMENS_16dp))

        Text(
            modifier = modifier.fillMaxWidth(),
            text = stringResource(R.string.oops_no_data),
            fontFamily = GilroyFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = TEXT_SIZE_18sp,
            color = Black,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp
        )
        Spacer(modifier = Modifier.height(DIMENS_8dp))
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(end = DIMENS_8dp, start = DIMENS_8dp),
            text = stringResource(R.string.oops_no_data_detail),
            fontFamily = GilroyFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = TEXT_SIZE_12sp,
            color = Black,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp
        )
        Spacer(modifier = Modifier.height(DIMENS_32dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Divider(
                modifier = Modifier
                    .height(DIMENS_24dp)
                    .width(2.dp)
                    .align(Alignment.Center),
                color = GrayBorderStroke
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,

                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Best selling products",
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = TEXT_SIZE_16sp,
                    color = Black,
                    textAlign = TextAlign.Center,
                    lineHeight = 30.sp,
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(start = DIMENS_16dp)


                )

                Text(
                    text = "Style auction",
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = TEXT_SIZE_16sp,
                    color = Black,
                    textAlign = TextAlign.Center,
                    lineHeight = 30.sp,
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(end = DIMENS_64dp)

                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyContentPreview() {
    EmptyCartContent()
}