package com.ad.pspexamencrud.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ad.pspexamencrud.model.entity.AgendaPOJO;

import java.util.List;

@Dao
public interface AgendaDao {
    @Query("SELECT * FROM agenda")
    LiveData<List<AgendaPOJO>> getAgendas();

    @Query("SELECT * FROM agenda WHERE id LIKE :id")
    AgendaPOJO getAgenda(long id);

    @Insert
    void addAgenda(AgendaPOJO agenda);

    @Delete
    void deleteAgenda(AgendaPOJO agenda);

    @Update
    void updateAgenda(AgendaPOJO agenda);
}
