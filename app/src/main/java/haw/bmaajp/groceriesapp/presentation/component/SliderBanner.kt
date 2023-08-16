package haw.bmaajp.groceriesapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.*
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_114dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_12dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_16dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_300dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_32dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_4dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_8dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue

@ExperimentalPagerApi
@Composable
fun SliderBanner(
    modifier: Modifier = Modifier.padding(DIMENS_16dp, DIMENS_4dp, DIMENS_16dp, DIMENS_16dp)
) {
    val pagerState = com.google.accompanist.pager.rememberPagerState(initialPage = 0)
    val imageSlider = listOf(
        painterResource(id = R.drawable.img_banner1),
        painterResource(id = R.drawable.img_banner2),
        painterResource(id = R.drawable.img_banner3)
    )

    LaunchedEffect(Unit) {
        while (true) {
            kotlinx.coroutines.yield()
            delay(2600)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }

    Column {
        com.google.accompanist.pager.HorizontalPager(
            count = imageSlider.size,
            state = pagerState,

            modifier = modifier
                .height(DIMENS_300dp)
                .fillMaxWidth()
        ) { page ->
            Card(
                shape = RoundedCornerShape(DIMENS_12dp),
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }

                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
            ) {
                Box {
                    Image(
                        painter = imageSlider[page],
                        contentDescription = stringResource(R.string.watch_auction),
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier.fillMaxSize()
                    )
                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                            .align(Alignment.BottomStart)
                            .padding(DIMENS_32dp,0.dp, DIMENS_12dp,DIMENS_12dp)


                    )
                }
            }
        }


    }
}

@ExperimentalPagerApi
@Preview
@Composable
fun SliderBannerPreview() {
    SliderBanner()
}