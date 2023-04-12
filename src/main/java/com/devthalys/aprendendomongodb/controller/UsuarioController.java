package com.devthalys.aprendendomongodb.controller;

import com.devthalys.aprendendomongodb.entity.Usuario;
import com.devthalys.aprendendomongodb.service.UsuarioService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> findByAllUsers(){
        return usuarioService.findAll();
    }

    @GetMapping("{id}")
    public Usuario findUserById(@PathVariable String id){
        return usuarioService.findById(id);
    }

    @Transactional
    @PostMapping
    @ResponseStatus(CREATED)
    public Usuario saveUser(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @GetMapping("/age")
    public List<Usuario> findUserByAge(@RequestParam("de") Integer de, @RequestParam("ate") Integer ate){
        return usuarioService.findUserByAge(de, ate);
    }
}
