package proyecto.tareas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyecto.tareas.entidades.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    /*@Query("SELECT * FROM usuario u WHERE u.nombre = :nombreUsuario")
   Usuario getByNombre (@Param("nombreUsuario") String nombreUsuario);*/
}
