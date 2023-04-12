package com.devthalys.aprendendomongodb.service.impl;

import com.devthalys.aprendendomongodb.entity.Usuario;
import com.devthalys.aprendendomongodb.repository.UsuarioRepository;
import com.devthalys.aprendendomongodb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {

        Usuario atleta = usuarioRepository
                .findById(usuario.getAtleta().getId())
                .orElseThrow(() -> new IllegalArgumentException("Atleta inexistente"));

        usuario.setAtleta(atleta);

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findById(String id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não existe"));
    }

    @Override
    public List<Usuario> findUserByAge(Integer de, Integer ate){
        return usuarioRepository.obterUsuariosIdade(de, ate);
    }
}
