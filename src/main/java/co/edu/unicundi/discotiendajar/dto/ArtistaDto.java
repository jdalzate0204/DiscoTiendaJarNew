package co.edu.unicundi.discotiendajar.dto;

import java.util.Set;
import javax.validation.*;
import javax.validation.constraints.*;

/**
 *
 * @author ALEJANDRA
 */
public class ArtistaDto {

   
    private Integer id;
    
    @NotNull(message = "nombre es obligatorio")
    @Size(min = 3, max = 50, message = "nombre debe estar entre 3 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "¡Solo se admiten letras!")
    private String nombre;
    
    @NotNull(message = "fechaNacimiento es obligatorio")
    private String fechaNacimiento; 
    
    @NotNull(message = "nacionalidad es obligatorio")
    @Size(min = 4, max = 20, message = "nacionalidad debe tener máximo 20 caracteres")
    @Pattern(regexp = "^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "¡Solo se admiten letras!")
    private String nacionalidad;
    
    //@NotNull(message = "idSexo es obligatorio")
    private Integer idSexo;
    
    //@NotNull(message = "idGeneroMusical es obligatorio")
    private Integer idGeneroMusical;
    
    private String sexo;
    private String generoMusical;

    public ArtistaDto() {
    }

    public ArtistaDto(Integer id, String nombre, String fechaNacimiento, String nacionalidad, String sexo, String generoMusical) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.generoMusical = generoMusical;
    }
    
    //Constructor Select
    public ArtistaDto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ArtistaDto(Integer id, String nombre, String fechaNacimiento, String nacionalidad, Integer idSexo, Integer idGeneroMusical) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.idSexo = idSexo;
        this.idGeneroMusical = idGeneroMusical;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public Integer getIdGeneroMusical() {
        return idGeneroMusical;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public void setIdGeneroMusical(Integer idGeneroMusical) {
        this.idGeneroMusical = idGeneroMusical;
    }

      public Set<ConstraintViolation<ArtistaDto>> validar(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }
}
