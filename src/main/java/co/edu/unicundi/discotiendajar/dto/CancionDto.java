package co.edu.unicundi.discotiendajar.dto;

import java.util.Set;
import javax.validation.*;
import javax.validation.constraints.*;

/**
 *
 * @author acer
 */
public class CancionDto {

    private Integer id;
    
    @NotNull(message = "nombre es obligatorio")
    @Size(min = 4, max = 30, message = "nombre debe estar entre 4 y 30 caracteres")
    private String nombre;
    
    @NotNull(message = "descripción es obligatorio")
    @Size(min = 5, max = 300, message = "descripción debe estar entre 5 y 300 caracteres")
    private String descripcion;
    
    @NotNull(message = "duracion es obligatorio")
    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9](:[0-5][0-9])?$", message = "¡Ingrese el formato 00:00:00!")
    private String duracion;
    
    @NotNull(message = "colaboraciones es obligatorio")
    private String colaboraciones;
    
    @NotNull(message = "precio es obligatorio")
    @Min(value = 2000)
    private Double precio;

    @NotNull(message = "idAlbum es obligatorio")
    private Integer idAlbum;
    
    @NotNull(message = "idAlbum es obligatorio")
    private Integer idFormato;
    
    private String album;
    private String formato;

    public CancionDto() {
    }

    public CancionDto(Integer id, String nombre, String descripcion, String duracion, String colaboraciones, Double precio, String album, String formato) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.colaboraciones = colaboraciones;
        this.precio = precio;
        this.album = album;
        this.formato = formato;
    }

    public CancionDto(Integer id, String nombre, String descripcion, String duracion, String colaboraciones, Double precio, Integer idAlbum, Integer idFormato) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.colaboraciones = colaboraciones;
        this.precio = precio;
        this.idAlbum = idAlbum;
        this.idFormato = idFormato;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getColaboraciones() {
        return colaboraciones;
    }

    public void setColaboraciones(String colaboraciones) {
        this.colaboraciones = colaboraciones;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Integer getIdFormato() {
        return idFormato;
    }

    public void setIdFormato(Integer idFormato) {
        this.idFormato = idFormato;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    public Set<ConstraintViolation<CancionDto>> validar(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }
}
