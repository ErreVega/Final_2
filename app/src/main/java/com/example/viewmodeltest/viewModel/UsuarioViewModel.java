package com.example.viewmodeltest.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.viewmodeltest.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioViewModel extends ViewModel {
    private List<Usuario> listUsers;

    public UsuarioViewModel(List<Usuario> listUsers) {
        this.listUsers = listUsers;
    }

    public UsuarioViewModel() {
        this.listUsers = new ArrayList<>();
    }

    public void addUser(Usuario user) {
        listUsers.add(user);
    }

    public List<Usuario> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<Usuario> listUsers) {
        this.listUsers = listUsers;
    }
}
