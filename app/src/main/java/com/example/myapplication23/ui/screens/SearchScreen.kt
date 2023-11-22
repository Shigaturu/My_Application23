package com.example.myapplication23.ui.screens


import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.myapplication23.R
import com.example.myapplication23.exo.PictureData
import com.example.myapplication23.exo.pictureList
import com.example.myapplication23.ui.theme.MyApplication23Theme

/*
@Preview()
@Composable
fun PictureRowItemPreview(image: ArrayList<PictureData>) {
    MyApplication23Theme {
        Column {
            PictureRowItem(pictureList[0])
        }
    }
}
*/

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PictureRowItem(data: PictureData) {
    var displayText by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 6.dp)
    ) {
        // Image à gauche
        GlideImage(
            model = data.url,
            contentDescription = data.text,
            loading = placeholder(R.mipmap.ic_launcher_round),
            failure = placeholder(R.mipmap.ic_launcher),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .heightIn(max = 100.dp)
                .widthIn(max = 100.dp)
        )

        // Espacement entre l'image et le texte
        Spacer(modifier = Modifier.width(8.dp))

        // Titre et description à droite
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .clickable { displayText = !displayText }
        ) {
            Text(
                text = data.text,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(4.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = if (displayText===false)
                {
                    data.longText.take(20)
                }
                else {
                    data.longText},
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth().animateContentSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    MyApplication23Theme {
        Surface(modifier = Modifier.fillMaxWidth(),  color = Color.LightGray) {
            SearchScreen()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    var searchText by rememberSaveable { mutableStateOf("")
    }
    // Filtrer la liste en fonction du texte de recherche
    val filteredList = pictureList.filter {
        it.text.contains(searchText, ignoreCase = true)
    }

    Column(modifier)
    {
        SearchBar(textValue = searchText, onValueChange = {searchText = it})
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(filteredList.size) {
                PictureRowItem(filteredList[it])
            }
        }
        buttons(ClearFilter = {searchText = ""})
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier, textValue: String, onValueChange:(String)->Unit) {


    TextField(
        value = textValue,
        onValueChange = { onValueChange(it) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = null
            )
        },
        label = { Text("Enter text") },
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Composable
fun buttons(modifier: Modifier = Modifier, ClearFilter:()-> Unit) {
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(0.dp, 6.dp,),
        horizontalArrangement = Arrangement.Center
    ) {
        // Titre et description à droite

        Button(
            onClick = ClearFilter,
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding
        ) {
            Icon(
                Icons.Filled.Clear,
                contentDescription = "Localized description",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Clear filter")
        }
        // Espacement entre l'image et le texte
        Spacer(modifier = Modifier.width(10.dp))


            Button(
                onClick = { /* Do something! */ },
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding
            ) {
                Icon(
                    Icons.Filled.Send,
                    contentDescription = "Localized description",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Load Data")
            }
        }
    }



