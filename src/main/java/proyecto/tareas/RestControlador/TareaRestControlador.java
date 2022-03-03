package proyecto.tareas.RestControlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.tareas.Excepciones.MiExcepcion;
import proyecto.tareas.entidades.Tarea;
import proyecto.tareas.servicios.TareaServicio;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaRestControlador {

    @Autowired
    TareaServicio tareaServicio;

    @GetMapping
    public List<Tarea> obtenerTodasTareas(){  // Obtiene todas las tareas de todos los usuarios, cumplidas o no.
        return tareaServicio.obtenerTodasTareas();
    }

    @GetMapping("/{id}")
    public List<Tarea> obtenerTareasPorId(@PathVariable Long id) throws MiExcepcion {
        List<Tarea> tareas = null;
        try {
            tareas = tareaServicio.verTareasPorIdUsuario(id);
        } catch (MiExcepcion e) {
            System.out.println("ERROR: "+e.getMessage());
            return tareas;
        }
        return tareas;
    }



}
