package com.devthalys.aprendendomongodb.service;

import com.devthalys.aprendendomongodb.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAll();

    Usuario save(Usuario usuario);

    Usuario findById(String id);

    List<Usuario> findUserByAge(Integer de, Integer ate);

}
