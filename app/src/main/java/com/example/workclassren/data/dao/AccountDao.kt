package com.example.workclassren.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.workclassren.data.model.AccountEntity

@Dao
interface AccountDao {
    @Query("SELECT * FROM AccountEntity")
    fun getAll(): List<AccountEntity>
}