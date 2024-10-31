package donad.vn.kotlin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import donad.vn.kotlin.ViewModelApp.ViewModelApp

@Composable
fun getApi(viewModel: ViewModelApp = viewModel()) {
    val productall by viewModel.products

    LaunchedEffect(Unit) {
        viewModel.getProductViewModel()
    }


    LazyColumn {
        items(productall) { item ->
            Card {
                Column {
                    Text(text = item._id)
                    Text(text = item.productName)
                    AsyncImage(
                        model = item.image,
                        contentDescription = "",
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                    )
                }
            }
        }
    }
}
