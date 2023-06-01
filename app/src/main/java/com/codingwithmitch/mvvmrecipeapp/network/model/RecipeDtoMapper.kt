package com.codingwithmitch.mvvmrecipeapp.network.model

import com.codingwithmitch.mvvmrecipeapp.domain.model.Recipe
import com.codingwithmitch.mvvmrecipeapp.network.util.DomainMapper

/**
 * Mapper class to map from RecipeNetworkEntity got from retrofit to our model class Recipe
 */


class RecipeDtoMapper:DomainMapper<RecipeDto,Recipe> {
    // map form RecipeNetworkEntity to Recipe
    override fun mapToDomainModel(model: RecipeDto): Recipe {
        return Recipe(
            id=model.pk,
            title = model.title,
            featured_image = model.featured_image,
            rating = model.rating,
            publisher = model.publisher,
            source_url = model.source_url,
            cooking_instructions = model.cooking_instructions,
            ingredients = model.ingredients,
            date_added = model.date_added,
            description = model.description,
            date_updated = model.date_updated
        )
    }
    // map form Recipe to RecipeNetworkEntity
    override fun mapToEntity(domainModel: Recipe): RecipeDto {
        return RecipeDto(
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
    fun toDomainList(initial:List<RecipeDto>):List<Recipe>{
        return initial.map{mapToDomainModel(it)}
    }

    //this function will map from list of class type Recipe as to create another list of class type RecipeNetworkEntity , by mapping to each one of them
    // to map it from Recipe to RecipeNetworkEntity
    fun fromDomainList(initial:List<Recipe>):List<RecipeDto>{
        return initial.map{mapToEntity(it)}
    }
}