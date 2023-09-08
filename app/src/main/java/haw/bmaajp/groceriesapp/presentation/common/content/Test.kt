package haw.bmaajp.groceriesapp.presentation.common.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val books = (1..10).map { "Book $it" }.toList()
private val wishlisted = (1..50).map { "Wishlisted Book $it" }

@Composable
fun NestedScrollScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        // My Books section
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("My Books", style = MaterialTheme.typography.h4)
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(books) { item ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .height(120.dp)
                                .width(90.dp)
                                .background(color = Color.Gray, shape = RoundedCornerShape(8.dp))
                        ) {
                            Text(item, modifier = Modifier.align(Alignment.Center))
                        }
                    }
                }
            }

        }
        item {
            Text("Whishlisted Books", style = MaterialTheme.typography.h4)
        }
        // Turning the list in a list of lists of two elements each
        items(wishlisted.windowed(2, 2, true)) { sublist ->
            Row(Modifier.fillMaxWidth()) {
                sublist.forEach { item ->
                    Text(
                        item, modifier = Modifier
                            .height(120.dp)
                            .padding(4.dp)
                            .background(Color.Yellow)
                            .fillParentMaxWidth(.5f)
                    )
                }
            }
        }
        items(wishlisted.windowed(2, 2, true)) { sublist ->
            Row(Modifier.fillMaxWidth()) {
                sublist.forEach { item ->
                    Text(
                        item, modifier = Modifier
                            .height(120.dp)
                            .padding(4.dp)
                            .background(Color.Green)
                            .fillParentMaxWidth(.5f)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ComposedLayoutPreview(){
    NestedScrollScreen()

}