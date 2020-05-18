package com.example.viewmodeltest.viewModel;
import androidx.lifecycle.ViewModel;

public class SumarViewModel extends ViewModel {


    private int resultado = 0;

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}