package com.evolvear.composetest

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.evolvear.composetest.utils.DataSource

@Composable
fun RecyclerViewData(dataItem : List<DataSource>){
    val scrollState = rememberLazyListState()
    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth(),
    ){
        items(dataItem){
            EachRow(it)
        }
    }
}

@Composable
fun EachRow(dataSource: DataSource){
    Card(
        modifier = Modifier
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            )
            .fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(10.dp)),
        elevation = 2.dp,
        border = BorderStroke(1.dp,Color.Black),
        backgroundColor = MaterialTheme.colors.error
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.aqeel),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(80.dp)
                    .align(Alignment.CenterVertically)
                    .clip(
                        RoundedCornerShape(CornerSize(10.dp))
                    )
            )
            Text(text = dataSource.description, modifier = Modifier.padding(8.dp), style = MaterialTheme.typography.caption)
        }
    }
}