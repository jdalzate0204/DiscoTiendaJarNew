package co.edu.unicundi.discotiendajar.dto;

import java.util.Set;
import javax.validation.*;
import javax.validation.constraints.*;

/**
 *
 * @author acer
 */
public class AlbumDto {
    private Integer id;
    
    @NotNull(message = "nombre es obligatorio") 
    @Size(min = 5, max = 30, message = "nombre debe estar entre 5 y 20 caracteres")
    private String nombre;
    
    @NotNull(message = "imagen es obligatorio")
    private String imagen;
    
    @NotNull(message = "descripción es obligatorio")
    @Size(min = 5, max = 300, message = "descripción debe estar entre 5 y 300 caracteres")
    private String descripcion;
    
    @NotNull(message = "fechaLanzamiento es obligatorio")
    private String fechaLanzamiento;
    
    @NotNull(message = "precio es obligatorio")
    @Min(value = 10000)
    private Double precio;
    
    @NotNull(message = "idArtista es obligatorio")
    private Integer idArtista;
    
    private String artista;

    public AlbumDto() {
    }

    //Constructor listar todos (JOIN)
    public AlbumDto(Integer id, String nombre, String imagen, String descripcion, String fechaLanzamiento, Double precio, String artista) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.precio = precio;
        this.artista = artista;
    }

    //Constructor Select
    public AlbumDto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public AlbumDto(Integer id, String nombre, String imagen, String descripcion, String fechaLanzamiento, Double precio, Integer idArtista) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.precio = precio;
        this.idArtista = idArtista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
    
    public Set<ConstraintViolation<AlbumDto>> validar(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }
}
