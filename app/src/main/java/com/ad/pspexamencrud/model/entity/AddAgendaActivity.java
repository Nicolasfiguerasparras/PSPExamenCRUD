package com.ad.pspexamencrud.model.entity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ad.pspexamencrud.R;
import com.ad.pspexamencrud.view.MainActivity;
import com.ad.pspexamencrud.viewmodel.AgendaViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class AddAgendaActivity extends AppCompatActivity {

    private AgendaPOJO agendaPOJO;
    private TextInputEditText tietAddNombre, tietAddApellidos, tietAddTelefono, tietAddFechaNacimiento, tietAddLocalidad, tietAddCalle, tietAddNumero;
    private Button btInsert;
    private AgendaViewModel agendaViewModel;
    public static final String NOMBRE = "NOMBRE";
    public static final String APELLIDOS = "APELLIDOS";
    public static final String TELEFONO = "TELEFONO";
    public static final String FECHA_NACIMIENTO = "FECHA_NACIMIENTO";
    public static final String LOCALIDAD = "LOCALIDAD";
    public static final String CALLE = "CALLE";
    public static final String NUMERO = "NUMERO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_agenda);

        init();
    }

    private void init() {
        tietAddNombre = findViewById(R.id.tietAddNombre);
        tietAddApellidos = findViewById(R.id.tietAddApellidos);
        tietAddTelefono = findViewById(R.id.tietAddTelefono);
        tietAddFechaNacimiento = findViewById(R.id.tietAddFechaNacimiento);
        tietAddLocalidad = findViewById(R.id.tietAddLocalidad);
        tietAddCalle = findViewById(R.id.tietAddCalle);
        tietAddNumero = findViewById(R.id.tietAddNumero);
        btInsert = findViewById(R.id.btnAddAgenda);

        agendaViewModel = new ViewModelProvider(this).get(AgendaViewModel.class);

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertAgenda();
            }
        });
    }

    private void insertAgenda() {
        String nombre = tietAddNombre.getText().toString();
        String apellidos = tietAddApellidos.getText().toString();
        String telefono = tietAddTelefono.getText().toString();
        String fecha_nacimiento = tietAddFechaNacimiento.getText().toString();
        String localidad = tietAddLocalidad.getText().toString();
        String calle = tietAddCalle.getText().toString();
        int numero = Integer.parseInt(tietAddNumero.getText().toString());

        agendaPOJO = new AgendaPOJO(); //nombre, apellidos, telefono,fecha_nacimiento, localidad, calle, numero
        agendaPOJO.setNombre(nombre);
        agendaPOJO.setApellidos(apellidos);
        agendaPOJO.setTelefono(telefono);
        agendaPOJO.setFecha_nacimiento(fecha_nacimiento);
        agendaPOJO.setLocalidad(localidad);
        agendaPOJO.setCalle(calle);
        agendaPOJO.setNumero(numero);
        agendaViewModel.insert(agendaPOJO);

        Intent intent = new Intent(AddAgendaActivity.this, MainActivity.class);
        startActivity(intent);
    }
}