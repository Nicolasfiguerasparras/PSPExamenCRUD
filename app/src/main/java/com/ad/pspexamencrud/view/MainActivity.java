package com.ad.pspexamencrud.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ad.pspexamencrud.R;
import com.ad.pspexamencrud.model.entity.AddAgendaActivity;
import com.ad.pspexamencrud.model.entity.AgendaPOJO;
import com.ad.pspexamencrud.model.entity.EditAgendaActivity;
import com.ad.pspexamencrud.view.adapter.RecyclerViewAdapter;
import com.ad.pspexamencrud.viewmodel.AgendaViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AgendaViewModel agendaViewModel;
    private Intent intent;
    private AgendaPOJO agendaPOJO;
    final RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this, new RecyclerViewAdapter.AgendaDiff());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agendaViewModel = new ViewModelProvider(this).get(AgendaViewModel.class);
        init();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.custom_menu, menu);
        return true;
    }

    private void init() {
        RecyclerView rv = findViewById(R.id.recycler_view);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        agendaViewModel.getAllAgendas().observe(this, new Observer<List<AgendaPOJO>>() {
            @Override
            public void onChanged(List<AgendaPOJO> agendaPOJOS) {
                adapter.submitList(agendaPOJOS);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menuBtnAdd:
                startAddAgendaActivity ();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void startAddAgendaActivity() {
        intent = new Intent(MainActivity.this, AddAgendaActivity.class);
        startActivity(intent);
    }
}