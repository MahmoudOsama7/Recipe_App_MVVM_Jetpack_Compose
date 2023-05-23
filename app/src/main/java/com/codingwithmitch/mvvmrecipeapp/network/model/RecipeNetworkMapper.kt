package com.codingwithmitch.mvvmrecipeapp.network.model

import com.codingwithmitch.mvvmrecipeapp.domain.model.Recipe
import com.codingwithmitch.mvvmrecipeapp.network.util.EntityMapper

/**
 * Mapper class to map from RecipeNetworkEntity got from retrofit to our model class Recipe
 */


class RecipeNetworkMapper:EntityMapper<RecipeNetworkEntity,Recipe> {
    // map form RecipeNetworkEntity to Recipe
    override fun mapFromEntity(entity: RecipeNetworkEntity): Recipe {
        return Recipe(
            id=entity.pk,
            title = entity.title,
            featured_image = entity.featured_image,
            rating = entity.rating,
            publisher = entity.publisher,
            source_url = entity.source_url,
            cooking_instructions = entity.cooking_instructions,
            ingredients = entity.ingredients,
            date_added = entity.date_added,
            description = entity.description,
            date_updated = entity.date_updated
        )
    }
    // map form Recipe to RecipeNetworkEntity
    override fun mapToEntity(domainModel: Recipe): RecipeNetworkEntity {
        return RecipeNetworkEntity(
            pk =domainModel.id,
            title = domainModel.title,
            featured_image = domainModel.featured_image,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            source_url = domainModel.source_url,
            cooking_instructions = domainModel.cooking_instructions,
            ingredients = domainModel.ingredients,
            date_added = domainModel.date_added,
            description = domainModel.description,
            date_updated = domainModel.date_updated
        )
    }

    //this function will map from list of class type RecipeNetworkEntity as to create another list of class type Recipe , by mapping to each one of them
    // to map it from RecipeNetworkEntity to Recipe
    fun fromEntityList(initial:List<RecipeNetworkEntity>):List<Recipe>{
        return initial.map{mapFromEntity(it)}
    }

    //this function will map from list of class type Recipe as to create another list of class type RecipeNetworkEntity , by mapping to each one of them
    // to map it from Recipe to RecipeNetworkEntity
    fun toEntityList(initial:List<Recipe>):List<RecipeNetworkEntity>{
        return initial.map{mapToEntity(it)}
    }
}