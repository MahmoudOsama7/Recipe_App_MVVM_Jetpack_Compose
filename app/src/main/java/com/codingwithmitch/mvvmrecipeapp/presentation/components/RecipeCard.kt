package com.codingwithmitch.mvvmrecipeapp.presentation.components

import androidx.cardview.widget.CardView
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.codingwithmitch.mvvmrecipeapp.R
import com.codingwithmitch.mvvmrecipeapp.domain.model.Recipe
import com.codingwithmitch.mvvmrecipeapp.presentation.theme.AppTheme

@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = 8.dp
    ) {
        Column {
            recipe.featured_image?.let { url ->
                Image(
                    painter = rememberImagePainter(url),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
            recipe.title?.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                ) {
                    Text(
                        text = title,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = AppTheme.typography.h5
                    )
                    Text(
                        text = recipe.rating.toString(),
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically),
                        style = AppTheme.typography.h1
                    )
                }
            }
        }
    }
}