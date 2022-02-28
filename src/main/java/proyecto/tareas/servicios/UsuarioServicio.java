package proyecto.tareas.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.tareas.Enums.Rol;
import proyecto.tareas.Excepciones.MiExcepcion;
import proyecto.tareas.entidades.Usuario;
import proyecto.tareas.repositorios.UsuarioRepositorio;

import java.util.List;

@Service
public class UsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> ObtenerUsuarios (){
        return usuarioRepositorio.findAll();
    }


    public void crearUsuario(String nombre, String apellido, String dni, String clave) throws MiExcepcion {
        System.out.println("Creando usuarioooooooooooooooooooooooooooo");
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDni(dni);
        usuario.setClave(clave);
        usuario.setCantidadTareas(0);
        usuario.setTareas(null);
        if (apellido.equals("admin")){
            usuario.setRol(Rol.ADMIN);
        } else usuario.setRol(Rol.USUARIO);
        usuarioRepositorio.save(usuario);
        System.out.println("Usuario creado si si siiiiiiiii");
    }
}
