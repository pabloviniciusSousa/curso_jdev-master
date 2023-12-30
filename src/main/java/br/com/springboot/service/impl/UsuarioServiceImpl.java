package br.com.springboot.service.impl;

import br.com.springboot.entity.Usuario;
import br.com.springboot.repository.IUsuarioRepository;
import br.com.springboot.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {


    @Autowired
    private IUsuarioRepository repository;


    @Override
    public Iterable<Usuario> findALl() {
        return repository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return repository.findById(id).get();
    }


    @Override
    public List<Usuario> findByName(String name) {
        List<Usuario> usuarios = repository.findByName(name.trim().toUpperCase());
        return usuarios;
    }

    @Override
    public Usuario create(Usuario usuario) {
        return repository.save(usuario);

    }

    @Override
    public ResponseEntity<?> update(Usuario usuario) {
       if (usuario.getId() == null){
           return new ResponseEntity<String>("Id não foi informado para atualização.", HttpStatus.OK);
        }
       Usuario user = repository.saveAndFlush(usuario);

        return new ResponseEntity<Usuario>(user, HttpStatus.OK);

    }



    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }
}


