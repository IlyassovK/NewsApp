package com.androiddevs.mvvmnewsapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


//Entity in our DataBase
@Entity(
    tableName = "articles"
)


data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    // room can work only with primitive classes, thus we have create typeconverter for source
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
) : Serializable