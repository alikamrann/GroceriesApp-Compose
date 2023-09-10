package haw.bmaajp.groceriesapp.presentation.screen.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.LeadingIconTab
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.presentation.screen.favorite.favoritelistscreen.FavoriteListScreen
import haw.bmaajp.groceriesapp.ui.theme.Black
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_16dp
import haw.bmaajp.groceriesapp.ui.theme.GilroyFontFamily
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_18sp
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    favoriteViewModel: FavoriteViewModel = hiltViewModel()
) {
    val productFavoriteList by favoriteViewModel.productFavoriteList.collectAsState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .padding(top = DIMENS_16dp, start = DIMENS_16dp)
                .align(Alignment.Start),
            text = stringResource(R.string.favorites),
            fontFamily = GilroyFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = TEXT_SIZE_18sp,
            color = Black
        )

        Spacer(modifier = Modifier.height(DIMENS_16dp))

        val tabData = getTabList()
        val pagerState = rememberPagerState(initialPage = tabData.size)
        Column(modifier = Modifier.fillMaxSize()) {
            TabLayout(tabData, pagerState)
            TabContent(tabData, pagerState)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(tabData: List<Pair<String, ImageVector>>, pagerState: PagerState) {

    val scope = rememberCoroutineScope()
    /* val tabColor = listOf(
         Color.Gray,
         Color.Yellow,
         Color.Blue,
         Color.Red
     )
 */
    TabRow(
        backgroundColor = Color.White,
        selectedTabIndex = pagerState.currentPage,
        contentColor = Color.Black,
        divider = {
            Spacer(modifier = Modifier.height(5.dp))
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier =
                Modifier
                    .pagerTabIndicatorOffset(pagerState, tabPositions)
                    .padding(end = DIMENS_16dp, start = DIMENS_16dp),
                height = 5.dp,
                color = colorResource(id = R.color.main_color)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        tabData.forEachIndexed { index, s ->
            LeadingIconTab(selected = pagerState.currentPage ==
                    index, onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(index)
                }
            },

                icon = {
                    Icon(
                        imageVector = s.second,
                        contentDescription = null
                    )
                },
                text = {
                    Text(
                        text = s.first,
                        style = LocalTextStyle.current.copy(color = colorResource(id = R.color.main_color))
                    )
                })
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabContent(tabData: List<Pair<String, ImageVector>>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabData.size) { index ->
        when (index) {
            0 -> {
                FavoriteListScreen()
            }

            1 -> {
                FavoriteListScreen()
            }


        }

    }

}

@Preview()
@Composable
fun PreviewTab() {
    FavoriteScreen()
}


private fun getTabList(): List<Pair<String, ImageVector>> {
    return listOf(
        "Public List" to Icons.Default.List,
        "Favorites" to Icons.Default.Favorite,
    )
}