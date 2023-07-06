package com.codingwithmitch.mvvmrecipeapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.codingwithmitch.mvvmrecipeapp.domain.model.Recipe
import com.codingwithmitch.mvvmrecipeapp.presentation.theme.AppTheme

@Composable
fun RecipeView(
    recipe: Recipe,

    ) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        recipe.featured_image?.let { url ->
            Image(
                painter = rememberImagePainter(url),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            recipe.title?.let { title ->
                Row(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
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
                recipe.publisher?.let { publisher ->
                    Text(
                        text = "Updated ${recipe.date_updated} by $publisher",
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .padding(bottom = 8.dp),
                        style = AppTheme.typography.caption
                    )
                }
                recipe.ingredients?.forEach { ingredient ->
                    Text(
                        text = ingredient,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .padding(bottom = 8.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }
}