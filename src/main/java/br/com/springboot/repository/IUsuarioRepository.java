package br.com.springboot.repository;

import br.com.springboot.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select u from Usuario u where upper(trim(u.name)) like %?1%")
    List<Usuario> findByName(String name);

}
