package com.ad.pspexamencrud.model;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.ad.pspexamencrud.AgendaApplication;
import com.ad.pspexamencrud.model.dao.AgendaDao;
import com.ad.pspexamencrud.model.entity.AgendaPOJO;
import com.ad.pspexamencrud.model.room.AgendaDatabase;

import java.util.List;

public class AgendaRepository {
    @SuppressLint("StaticFieldLeak")
    private static AgendaRepository agendaRepository;

    private AgendaDao agendaDao;
    private LiveData<List<AgendaPOJO>> listaAgendasLive;
    private AgendaDatabase database;

    public AgendaRepository(Context context) {
        Context appContext = context.getApplicationContext();
        database = AgendaDatabase.getDatabase(context);
        agendaDao = database.getAgendaDao();
        listaAgendasLive = agendaDao.getAgendas();
    }

    public static AgendaRepository get(Context context) {
        if (agendaRepository == null) {
            agendaRepository = new AgendaRepository(context);
        }
        return agendaRepository;
    }

    public LiveData<List<AgendaPOJO>> getAgendas() {
        return listaAgendasLive;
    }

    /*
        public void getAgenda(String id) {
            AgendaApplication.threadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    agendaDao.getAgenda(id);
                }
            });
        }
    */

    public void addAgenda(AgendaPOJO agenda) {
        AgendaApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                agendaDao.addAgenda(agenda);
            }
        });
    }

    public void updateAgenda(AgendaPOJO agenda) {
        AgendaApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                agendaDao.updateAgenda(agenda);
            }
        });
    }

    public void deleteAgenda(AgendaPOJO agenda) {
        AgendaApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                agendaDao.deleteAgenda(agenda);
            }
        });
    }

    public void get(long id){
        AgendaApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                agendaDao.getAgenda(id);
            }
        });
    }
}