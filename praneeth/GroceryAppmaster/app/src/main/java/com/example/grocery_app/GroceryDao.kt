package com.example.grocery_app

import androidx.room.*
import androidx.lifecycle.LiveData




@Dao
interface GroceryDao {

       @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(item: GroceryItems)


        @Delete
        suspend fun delete(item: GroceryItems)


        @Query("SELECT* FROM grocery_items")
        fun getALLGroceryItems() : LiveData<List<GroceryItems>>
}