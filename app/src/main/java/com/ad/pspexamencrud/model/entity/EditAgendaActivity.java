package com.ad.pspexamencrud.model.entity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ad.pspexamencrud.R;
import com.ad.pspexamencrud.viewmodel.AgendaViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class EditAgendaActivity extends AppCompatActivity {

    private AgendaPOJO agendaPOJO;
    private TextInputEditText tietEditNombre, tietEditApellidos, tietEditTelefono, tietEditFechaNacimiento, tietEditLocalidad, tietEditCalle, tietEditNumero;
    private Button btnDeleteAgenda, btnUpdateAgenda;
    private AgendaViewModel agendaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_agenda);

        initViews();
        initValues();
        initButtons();
        /*tietEditNombre = findViewById(R.id.tietEditNombre);
        tietEditNombre.setText("Hola");

         */
    }

    private void initViews() {
        tietEditNombre = findViewById(R.id.tietEditNombre);
        tietEditApellidos = findViewById(R.id.tietEditApellidos);
        tietEditTelefono = findViewById(R.id.tietEditTelefono);
        tietEditFechaNacimiento = findViewById(R.id.tietEditFechaNacimiento);
        tietEditLocalidad = findViewById(R.id.tietEditLocalidad);
        tietEditCalle = findViewById(R.id.tietEditCalle);
        tietEditNumero = findViewById(R.id.tietEditNumero);
        btnUpdateAgenda = findViewById(R.id.btnUpdateAgenda);
        btnDeleteAgenda = findViewById(R.id.btnDeleteAgenda);

        agendaViewModel = new ViewModelProvider(this).get(AgendaViewModel.class);
    }

    private void initButtons() {
        btnUpdateAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = agendaPOJO.getId();
                agendaPOJO.setId(id);
                agendaPOJO.setNombre(tietEditNombre.getText().toString());
                agendaPOJO.setApellidos(tietEditApellidos.getText().toString());
                agendaPOJO.setTelefono(tietEditTelefono.getText().toString());
                agendaPOJO.setFecha_nacimiento(tietEditFechaNacimiento.getText().toString());
                agendaPOJO.setLocalidad(tietEditLocalidad.getText().toString());
                agendaPOJO.setCalle(tietEditCalle.getText().toString());
                agendaPOJO.setNumero(Integer.parseInt(tietEditNumero.getText().toString()));
                agendaViewModel.update(agendaPOJO);
                finish();
            }
        });

        btnDeleteAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agendaViewModel.delete(agendaPOJO);
                finish();
            }
        });
    }

    private void initValues() {
        agendaPOJO = (AgendaPOJO) getIntent().getExtras().getSerializable("contacto");

        tietEditNombre.setText(agendaPOJO.getNombre().toString());
        tietEditApellidos.setText(agendaPOJO.getApellidos().toString());
        tietEditTelefono.setText(agendaPOJO.getTelefono().toString());
        tietEditFechaNacimiento.setText(agendaPOJO.getFecha_nacimiento().toString());
        tietEditLocalidad.setText(agendaPOJO.getLocalidad().toString());
        tietEditCalle.setText(agendaPOJO.getCalle().toString());
        tietEditNumero.setText(String.valueOf(agendaPOJO.getNumero()));
    }
}