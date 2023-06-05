package com.codingwithmitch.mvvmrecipeapp.di


import android.content.Context
import com.codingwithmitch.mvvmrecipeapp.presentation.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app:Context): BaseApplication {
        return app as BaseApplication
    }

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideRetrofitToken():String{
        return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }

    //token for website food2Fork
    @Singleton
    @Provides
    fun provideRandomStrings():String{
        return "Hey Look "
    }
}