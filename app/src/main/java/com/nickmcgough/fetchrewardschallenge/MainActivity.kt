package com.nickmcgough.fetchrewardschallenge

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nickmcgough.fetchrewardschallenge.datamodels.ListItem
import com.nickmcgough.fetchrewardschallenge.utils.getJSONObjectFromAssetsFolder
import com.nickmcgough.fetchrewardschallenge.utils.sortItemListByNameThenListId

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val itemList = getJSONObjectFromAssetsFolder(baseContext, "hiring.json")
        Log.i("Main", "Item List: $itemList")
        val sortedItemList = sortItemListByNameThenListId(itemList)
        Log.i("Main", "Sorted Item List: $sortedItemList")
        enableEdgeToEdge()
        setContent {
            LazyListItemColumn(sortedItemList)
        }
    }
}

@Composable
fun LazyListItemColumn(list: List<ListItem>){
    LazyColumn(
        modifier = Modifier
            .padding(start = 10.dp, top = 25.dp, bottom = 20.dp)
            .fillMaxWidth(),
    ) {
        items(list, key = { item -> item.id }) { item ->
            if (!item.name.isNullOrEmpty()) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    fontSize = 18.sp,
                    text = "List ID: ${item.listId}, Name: ${item.name}, ID: ${item.id}"
                )
            }
        }
    }
}