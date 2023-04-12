package com.devthalys.aprendendomongodb.repository;

import com.devthalys.aprendendomongodb.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    @Query("{ $and: [ { 'age':  { $gt: ?0 } }, { 'age': { $lt: ?1 } } ] }")
    public List<Usuario> obterUsuariosIdade(Integer de, Integer ate);

    public List<Usuario> findByName(String name);
}
