package com.androiddevs.mvvmnewsapp.db

import android.content.Context
import androidx.room.*
import com.androiddevs.mvvmnewsapp.models.Article

@Database(
    entities = [Article::class],
    version = 2
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao

    // recreate of database instance which is a singleton

    companion object{
        @Volatile
        private var instance: ArticleDatabase? = null
        private var LOCK = Any()

        // if current instance is null we will set this instance in the synchronized block
        // after we check again, if it is null we create database
        // instance will be used to access the dao class
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context:Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
                ).fallbackToDestructiveMigration().build()
    }
}