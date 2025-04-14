package com.example.workclassren.data.dataBase

import android.content.Context
import androidx.room.Room

object dataBaseProvider{
    private var instance: AppDataBase? = null

    fun getDataBase(context: Context):AppDataBase{
        return instance ?: synchronized(this){
            val db =Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "app_database"
            ).build()
            instance = db
            db
        }
    }
}