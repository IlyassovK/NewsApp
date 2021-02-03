package com.androiddevs.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.mvvmnewsapp.models.Article

// DAO - data access objects define main function to work with db
@Dao
interface ArticleDao {

    // onConflict defines strategy of Insert function
    // for example if we already have that article in our DB we replacing it
    // upsert = insert + update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    // LiveData notify views about changing data in DB
    @Query("Select * from articles")
    fun getAllArticles():LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}