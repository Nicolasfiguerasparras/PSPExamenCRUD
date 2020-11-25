package com.ad.pspexamencrud.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ad.pspexamencrud.model.AgendaRepository;
import com.ad.pspexamencrud.model.entity.AgendaPOJO;

import java.util.List;

public class AgendaViewModel extends AndroidViewModel {

    private AgendaRepository repository;
    private LiveData<List<AgendaPOJO>> liveAgenda;

    public AgendaViewModel(@NonNull Application application) {
        super(application);
        repository = new AgendaRepository(application);
        liveAgenda = repository.getAgendas();
    }

    public LiveData<List<AgendaPOJO>> getAllAgendas(){
        return liveAgenda;
    }

    public void insert(AgendaPOJO agendaPOJO){
        repository.addAgenda(agendaPOJO);
    }

    public void delete(AgendaPOJO agendaPOJO){
        repository.deleteAgenda(agendaPOJO);
    }

    public void update(AgendaPOJO agendaPOJO){
        repository.updateAgenda(agendaPOJO);
    }

    public void get(long id){
        repository.get(id);
    }
}