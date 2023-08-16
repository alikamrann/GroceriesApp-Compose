package haw.bmaajp.groceriesapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_16dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_4dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_8dp
import haw.bmaajp.groceriesapp.ui.theme.GilroyFontFamily


@Composable
fun SaleCompose() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(DIMENS_16dp, DIMENS_4dp, DIMENS_16dp, DIMENS_4dp)

            .wrapContentWidth()
            .wrapContentHeight()

            .background(colorResource(id = R.color.light_gray), shape = RoundedCornerShape(4.dp))

    ) {
        Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_agent),
            contentDescription = "Person Icon",
            tint = Color.Black,
            modifier = Modifier.size(height = 28.dp, width = 28.dp),
        )
        Text(stringResource(R.string.watch_auction),
            color = colorResource(id = R.color.black),
            fontSize = 12.sp,
            fontFamily = GilroyFontFamily,
            modifier = Modifier.padding(6.dp,0.dp), maxLines = 1)

    }
}
@Composable
@Preview
fun SaleComposePreview() {
    SaleCompose()
}