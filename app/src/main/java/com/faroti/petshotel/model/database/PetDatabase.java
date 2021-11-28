package com.faroti.petshotel.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.faroti.petshotel.model.database.dao.UserDao;
import com.faroti.petshotel.model.database.entities.Proveedor;
import com.faroti.petshotel.model.database.entities.User;

@Database(entities = {User.class, Proveedor.class}, version = 1)
public abstract class PetDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();






    private static volatile PetDatabase INSTANCE;

    public static PetDatabase getDatabase(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    PetDatabase.class, "database-name")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

}
