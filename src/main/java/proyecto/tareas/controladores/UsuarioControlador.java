
package proyecto.tareas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import proyecto.tareas.Excepciones.MiExcepcion;
import proyecto.tareas.servicios.UsuarioServicio;


@Controller
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;



    @PostMapping("/registrarUsuario")
    public String registrarUsuario (@RequestParam String nombre,@RequestParam String apellido, @RequestParam String dni,@RequestParam String clave) throws MiExcepcion {
        System.out.println("Entro al controller de registrar usuario");
        try {
            usuarioServicio.crearUsuario(nombre,apellido,dni,clave);
        }catch (MiExcepcion ex){
            throw new MiExcepcion("ERROR: No se pudo guardar el usuario.");
        }

        return "redirect:/";
    }
}
