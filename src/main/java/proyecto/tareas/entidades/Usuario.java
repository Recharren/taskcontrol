
package proyecto.tareas.entidades;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import proyecto.tareas.Enums.Rol;

@Entity
public class Usuario {
    
    @Id     
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre, apellido, dni, clave;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    private Integer cantidadTareas;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "usuario")
    @JsonIgnoreProperties(value = "usuario")
    private List<Tarea> tareas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Integer getCantidadTareas() {
        return cantidadTareas;
    }

    public void setCantidadTareas(Integer cantidadTareas) {
        this.cantidadTareas = cantidadTareas;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
}
