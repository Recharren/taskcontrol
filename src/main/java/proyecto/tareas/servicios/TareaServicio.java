package proyecto.tareas.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.tareas.Excepciones.MiExcepcion;
import proyecto.tareas.entidades.Tarea;
import proyecto.tareas.entidades.Usuario;
import proyecto.tareas.repositorios.TareaRepositorio;
import proyecto.tareas.repositorios.UsuarioRepositorio;

import java.util.Date;

@Service
public class TareaServicio {

    @Autowired
    TareaRepositorio tareaRepositorio;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;


    public void crearTarea(Usuario usuario, String nombre, String descripcion, Date fechaFinal) throws MiExcepcion {
        Tarea tarea = new Tarea();
        tarea.setUsuario(usuario);

        tarea.setNombre(nombre);
        tarea.setDescripcion(descripcion);
        tarea.setFechaFinal(fechaFinal);
        tarea.setFechaCreacion(new Date());
        tarea.setNota("Sin notas");
        tarea.setCumplida(false);
        tareaRepositorio.save(tarea);
    }

    public void verTareasPorIdUsuario(Long id) {
        tareaRepositorio.verTareasPorIdUsuario(id);
    }

   /* public void crearTarea(Long usuarioId,String nombre, String descripcion, Date fechaFinal) throws MiExcepcion {
        Tarea tarea = new Tarea();
        tarea.setUsuario(usuarioRepositorio.findById(usuarioId).get());

        tarea.setNombre(nombre);
        tarea.setDescripcion(descripcion);
        tarea.setFechaFinal(fechaFinal);
        tarea.setFechaCreacion(new Date());
        tarea.setNota("Sin notas");
        tarea.setCumplida(false);
        tareaRepositorio.save(tarea);
    }*/
/*
    public List<Tarea> verTareas(String nombreUsuario) throws MiExcepcion{
        Usuario usuario = usuarioRepositorio.getByNombre(nombreUsuario);
        if (usuarioRepositorio.findById(usuario.getId()).isPresent()){
            return tareaRepositorio.findAll();
        } else {
            throw new MiExcepcion("El usuario "+usuario.getNombre()+" no tiene tareas asignadas");
        }
    }*/
}
