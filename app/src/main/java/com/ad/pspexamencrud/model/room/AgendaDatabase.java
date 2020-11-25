package com.ad.pspexamencrud.model.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ad.pspexamencrud.model.dao.AgendaDao;
import com.ad.pspexamencrud.model.entity.AgendaPOJO;

@Database(entities = {AgendaPOJO.class}, version = 1, exportSchema = false)
public abstract class AgendaDatabase extends RoomDatabase {
    public abstract AgendaDao getAgendaDao();

    private static volatile AgendaDatabase INSTANCE;

    public static synchronized AgendaDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AgendaDatabase.class, "AgendaDatabase.sqlite").build();
        }
        return INSTANCE;
    }
}
