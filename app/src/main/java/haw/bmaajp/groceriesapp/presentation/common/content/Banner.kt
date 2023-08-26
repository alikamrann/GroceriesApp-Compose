package haw.bmaajp.groceriesapp.presentation.common.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import haw.bmaajp.groceriesapp.R

@Composable
fun Banners(modifier: Modifier = Modifier) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.img_banner1),
            contentDescription = "banner1",
            Modifier.padding(16.dp,16.dp,16.dp,8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.img_banner2),
            contentDescription = "banner2",
            Modifier.padding(16.dp,0.dp,16.dp,16.dp)
        )
    }
}

@Preview
@Composable
fun BannerPreview() {
    Banners()
}