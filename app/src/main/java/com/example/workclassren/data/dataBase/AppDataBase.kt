package com.example.workclassren.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.workclassren.data.dao.AccountDao
import com.example.workclassren.data.model.AccountEntity

@Database(entities=[AccountEntity::class], version=1)
        abstract class AppDataBase: RoomDatabase(){
            abstract fun accountDao(): AccountDao
        }