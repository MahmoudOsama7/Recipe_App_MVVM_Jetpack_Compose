package com.codingwithmitch.mvvmrecipeapp.network.util

/**
 * entity mapper interface to use to map between Entity and Domain level , which will be in this case Recipe and RecipeNetworkEntity
 */
interface DomainMapper<T,DomainModel>{
    fun mapToDomainModel(model:T):DomainModel
    fun mapToEntity(domainModel: DomainModel):T
}