package com.example.viewmodeltest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.viewmodeltest.R;
import com.example.viewmodeltest.Sumar;
import com.example.viewmodeltest.viewModel.SumarViewModel;

public class ViewModelSumarActivity extends AppCompatActivity {
    TextView tvSumar, tvSumarViewModel;
    Button btSumar;
    private int numero=0;
    private SumarViewModel sumarViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_sumar);
        configView();
    }
    private void configView(){
        // Cada vez que se gira y se destruye la activity, el ViewModel entiende que
        // debe pasar los datos de la actividad vieja a la nueva
        // El metodo of esta deprecated:
        // sumarViewModel = ViewModelProviders.of(this).get(SumarViewModel.class);
        // Ahora hacemos:
        // Java equivalent: YourViewModel viewModel =
        // new ViewModelProvider(this).get(YourViewModel.class);
        sumarViewModel = new ViewModelProvider(this).get(SumarViewModel.class);
        tvSumar = findViewById(R.id.textView);
        tvSumarViewModel = findViewById(R.id.textView2);
        tvSumar.setText(" " + numero);
        tvSumarViewModel.setText(" " + sumarViewModel.getResultado());
        btSumar = findViewById(R.id.button);
        btSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hacemos la suma de las dos formas, usando y sin usar ViewModel
                numero = Sumar.sumar(numero);
                sumarViewModel.setResultado(Sumar.sumar(sumarViewModel.getResultado()));
                tvSumar.setText(" "+numero);
                tvSumarViewModel.setText(" "+sumarViewModel.getResultado());
            }
        });
    }
}
