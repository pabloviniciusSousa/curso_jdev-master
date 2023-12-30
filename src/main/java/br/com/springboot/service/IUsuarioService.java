package br.com.springboot.service;

import br.com.springboot.entity.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUsuarioService {


     Iterable<Usuario> findALl();

     Usuario findById(Long id);

    public List<Usuario> findByName(String name);
     Usuario create(Usuario usuario);

    public ResponseEntity<?> update(Usuario usuario);

    void delete(Long id);


}
