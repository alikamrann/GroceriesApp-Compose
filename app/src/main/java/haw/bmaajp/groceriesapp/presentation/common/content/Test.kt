package haw.bmaajp.groceriesapp.presentation.common.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutInCompose() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (textView6, textView7, view) = createRefs()

        TextView(
            text = "TextView",
            modifier = Modifier
                .constrainAs(textView6) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .height(100.dp)
                .width(100.dp)
        )

        TextView(
            text = "TextView",
            modifier = Modifier
                .constrainAs(textView7) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .height(100.dp)
                .width(100.dp)
        )

        View(
            modifier = Modifier
                .constrainAs(view) {
                    top.linkTo(parent.top)
                    start.linkTo(textView6.end)
                    end.linkTo(textView7.start)
                }
                .height(100.dp)
                .wrapContentWidth()
                .background(Color.Black)
        )
    }
}

@Composable
fun TextView(text: String, modifier: Modifier) {
    BasicTextField(
        value = text,
        onValueChange = {},
        singleLine = true,
        textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
        modifier = modifier
            .background(Color.Gray)
            .padding(8.dp)
    )
}

@Composable
fun View(modifier: Modifier) {
    Spacer(modifier = modifier.background(Color.Blue))
}

@Preview
@Composable
fun ConstraintLayoutInComposePreview() {
    ConstraintLayoutInCompose()
}