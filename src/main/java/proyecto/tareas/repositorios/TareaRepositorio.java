package proyecto.tareas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.tareas.entidades.Tarea;

@Repository
public interface TareaRepositorio extends JpaRepository<Tarea, Long> {


    void verTareasPorIdUsuario(Long id);
}
