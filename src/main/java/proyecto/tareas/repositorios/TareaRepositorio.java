package proyecto.tareas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyecto.tareas.entidades.Tarea;

import java.util.List;

@Repository
public interface TareaRepositorio extends JpaRepository<Tarea, Long> {

    @Query(value = "SELECT t FROM Tarea t WHERE t.usuario.id = :idUsuario")
    public List<Tarea> verTareasPorIdUsuario(@Param("idUsuario") Long idUsuario);
}
