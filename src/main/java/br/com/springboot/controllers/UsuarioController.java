package br.com.springboot.controllers;

import br.com.springboot.entity.Usuario;
import br.com.springboot.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController  {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Iterable <Usuario>> findAll(){
        return ResponseEntity.ok(usuarioService.findALl());
    }
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<Usuario> findById(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }
    @GetMapping("/findname")
    @ResponseBody
    public List<Usuario> findByName(@RequestParam(name = "name") String name){
        List<Usuario> list = usuarioService.findByName(name);
        return list;
    }

    @PostMapping
    public ResponseEntity<Usuario> create(Usuario usuario){
        usuarioService.create(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Usuario usuario){
        usuarioService.update(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam  Long id){
        usuarioService.delete(id);
        return new ResponseEntity<String>("User deletado com sucesso", HttpStatus.OK);
    }


}