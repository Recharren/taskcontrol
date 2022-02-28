
package proyecto.tareas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import proyecto.tareas.entidades.Tarea;
import proyecto.tareas.entidades.Usuario;
import proyecto.tareas.servicios.TareaServicio;
import proyecto.tareas.servicios.UsuarioServicio;

import java.util.List;

@Controller
public class PortalControlador {

    @Autowired UsuarioServicio usuarioServicio;

    @Autowired
    TareaServicio tareaServicio;
    
    @GetMapping("/")
public String index(ModelMap modelo){
        List<Usuario> usuarios = usuarioServicio.ObtenerUsuarios();
        modelo.put("tarea", new Tarea());
        modelo.put("usuarios",usuarios);
return "index.html";
}

@GetMapping("/crearUsuario")
    public String crearUsuario(ModelMap modelo){
        return "crearUsuario.html";
}

@GetMapping("/crearTarea")
    public String crearTarea(ModelMap modelo){
    List<Usuario> usuarios = usuarioServicio.ObtenerUsuarios();
    modelo.put("tarea", new Tarea());
    modelo.put("usuarios",usuarios);
        return "crearTarea.html";
}





}
