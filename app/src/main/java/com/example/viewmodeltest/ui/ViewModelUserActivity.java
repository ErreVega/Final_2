package com.example.viewmodeltest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.viewmodeltest.R;
import com.example.viewmodeltest.Usuario;
import com.example.viewmodeltest.viewModel.UsuarioViewModel;

import java.util.ArrayList;
import java.util.Iterator;

public class ViewModelUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_user);


        // inicializamos nuestra clase ViewModel
        // instanciando ViewModel
        final UsuarioViewModel usuarioViewModel;
        usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);
        final ArrayList listaUsuarios = new ArrayList<>();
        // Campos de texto no editables
        final TextView tvUsuario = findViewById(R.id.userActivityTvUser);
        final TextView tvUsuarioViewModel = findViewById(R.id.userActivityTvUserViewModel);
        // Campos de texto editables
        final EditText etNombre = findViewById(R.id.userActivityEtNombre);
        final EditText etEdad = findViewById(R.id.userActivityEtEdad);
        etNombre.setText("");
        etEdad.setText("");
        Button btSalvar = findViewById(R.id.userActivityBtSalvar);
        Button btVerUsuario = findViewById(R.id.userActivityBtVer);

        btVerUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sUsuarios = "";
                Iterator<Usuario> ite = listaUsuarios.iterator();
                while (ite.hasNext()) {
                    sUsuarios += ite.next().toString() + "\n";
                }
                tvUsuario.setText(sUsuarios + listaUsuarios.size());
                sUsuarios = "";
                Iterator<Usuario> VMite = usuarioViewModel.getListUsers().iterator();
                while (VMite.hasNext()) {
                    sUsuarios += VMite.next().toString() + "\n";
                }
                tvUsuarioViewModel.setText(sUsuarios +
                        usuarioViewModel.getListUsers().size());
            }
        });
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creamos un usuario con los datos introducidos en la actividad
                Usuario usu = new Usuario(etNombre.getText().toString(),
                        etEdad.getText().toString());
                // y lo guardamos en la lista de usuarios
                listaUsuarios.add(usu);
                usuarioViewModel.addUser(usu);

                Toast toast = Toast.makeText(getApplicationContext(), "Guardado", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

}
