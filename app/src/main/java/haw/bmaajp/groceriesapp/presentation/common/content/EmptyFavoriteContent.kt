package haw.bmaajp.groceriesapp.presentation.common.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
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
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_8dp
import haw.bmaajp.groceriesapp.ui.theme.GilroyFontFamily
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_16sp
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_18sp

@Composable
fun EmptyFavoriteContent(
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
            painter = painterResource(id = R.drawable.empty_favorite_list_icon),
            contentDescription = stringResource(R.string.image_content_empty)
        )

        Spacer(modifier = Modifier.height(DIMENS_16dp))

        Text(
            modifier = modifier.fillMaxWidth(),
            text = stringResource(R.string.log_in_to_see_your_favorite_styles),
            fontFamily = GilroyFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = TEXT_SIZE_18sp,
            color = Black,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp
        )
        Spacer(modifier = Modifier.height(DIMENS_16dp))

        Button(onClick = {},
            shape = RoundedCornerShape(DIMENS_8dp)
        , modifier = Modifier
                .padding(
                    end = DIMENS_16dp,
                    start = DIMENS_16dp,
                    top = DIMENS_16dp,
                    bottom = DIMENS_16dp
                )
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)) {
            Text(
                text = stringResource(R.string.log_in),
                fontSize = TEXT_SIZE_16sp,
                modifier = Modifier.padding(
                    top = DIMENS_8dp,
                    bottom = DIMENS_8dp
                )


            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun EmptyFavoriteContentPreview() {
    EmptyCartContent()
}