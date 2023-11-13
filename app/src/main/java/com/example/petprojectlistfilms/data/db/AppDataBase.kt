package com.example.petprojectlistfilms.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [
        UserDbModel::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        //проверяем существует ли экземпляр, если да то новый не создаем
        // а возвращаем существующий
        private var INSTANCE: AppDataBase? = null
        //объект  синхронизации
        private val LOCK = Any()
        //имя БД
        private const val DB_NAME = "ListFilmsDataBase"
        //проверка существования экземпляра
        fun getInstance(application: Application):AppDataBase{
            INSTANCE?.let{
                return it
            }
            //это нужно, если два потока зайдут в этот метод
            //то они оба дойдут до этого метода, а здесь будут заходить по
            //очереди и Instance не перезапишется
            synchronized(LOCK){
                INSTANCE?.let{
                    return it
                }
            }
            val db = Room.databaseBuilder(
                application,
                AppDataBase::class.java,
                DB_NAME
            )
                .allowMainThreadQueries()//todo(убрать)
                .build()
            INSTANCE = db
            return db
        }
    }
}