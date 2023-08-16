package haw.bmaajp.groceriesapp.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.ui.theme.*


@Composable
fun SearchViewBar(
    modifier: Modifier = Modifier,
    query: String = "",
    hint: String,
    onClickSearch: (String) -> Unit = {},
    onValueChange: (String) -> Unit = {},
) {
    TextField(
        modifier = modifier
            .padding(DIMENS_16dp, DIMENS_16dp, DIMENS_16dp, DIMENS_4dp)
            .border(
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(4.dp),
            )
            .fillMaxWidth()
            .height(DIMENS_64dp)
            .background(color = Color.White),
        value = query,
        onValueChange = {
            onValueChange.invoke(it)
        },
        leadingIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .size(DIMENS_40dp)
                        .padding(DIMENS_8dp,0.dp,0.dp,0.dp)
                )
                Text(
                    stringResource(R.string.digistyle),
                    color = colorResource(id = R.color.black),
                    fontSize = 20.sp,
                    fontFamily = GilroyFontFamily,
                    modifier = Modifier.padding(6.dp, 0.dp, 0.dp, 0.dp),
                    fontWeight = FontWeight.Light
                )
            }

        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(
                text = hint,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Light,
                color = Color.LightGray,
                fontSize = TEXT_SIZE_16sp
            )
        },
        singleLine = true,
        textStyle = TextStyle(
            fontFamily = GilroyFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Black,
            fontSize = TEXT_SIZE_12sp
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onClickSearch.invoke(query)
            }
        ),
    )
}

@Preview
@Composable
fun SearchViewBarPreview() {
    SearchViewBar(
        hint = stringResource(id = R.string.search_category),
        onValueChange = {}
    )
}