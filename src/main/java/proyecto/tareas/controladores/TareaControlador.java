package proyecto.tareas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import proyecto.tareas.Excepciones.MiExcepcion;
import proyecto.tareas.entidades.Tarea;
import proyecto.tareas.entidades.Usuario;
import proyecto.tareas.repositorios.UsuarioRepositorio;
import proyecto.tareas.servicios.TareaServicio;

import java.util.Date;
import java.util.List;

@Controller
public class TareaControlador {

    @Autowired
    TareaServicio tareaServicio;


    @PostMapping("/registrarTarea")
    public String crearTarea(ModelMap modelo, @ModelAttribute Tarea tarea){
        System.out.println("a ver si probaamos si sale el usuariooooooooooooo"+tarea.getUsuario().getApellido());
        try {
            tareaServicio.crearTarea(tarea.getUsuario(), tarea.getNombre(),tarea.getDescripcion(),tarea.getFechaFinal());
        }catch (MiExcepcion ex){
            String error = ex.getMessage();
            modelo.put("error",error);
        }
        return "redirect:/";
    }

    @GetMapping("/verTareas")
    public String verTareas (ModelMap modelo, @ModelAttribute Tarea tarea){
        tareaServicio.verTareasPorIdUsuario(tarea.getId());
        return "verTareas.html";
    }



    /*@PostMapping("/registrarTarea")
    public String crearTarea(ModelMap modelo,@RequestParam Long usuarioId ,@RequestParam String nombre,
                           @RequestParam String descripcion, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFinal){
        System.out.println("a ver si probaamos si sale el usuariooooooooooooo"+usuarioId);
        try {
            tareaServicio.crearTarea(usuarioId, nombre,descripcion,fechaFinal);
        }catch (MiExcepcion ex){
            String error = ex.getMessage();
            modelo.put("error",error);
        }
        return "redirect:/";
    }*/
/*
    @GetMapping("/verTareas")
    public String verTareas(ModelMap modelo, @RequestParam String nombreUsuario ){
        try {
            List<Tarea> tareas = tareaServicio.verTareas(nombreUsuario);
            modelo.put("tareas",tareas);
            modelo.put("usuario", usuarioRepositorio.getByNombre(nombreUsuario));
        }catch (MiExcepcion ex){
            modelo.put("error",ex.getMessage());
        }
        return "tareas.html";
    }*/
}
