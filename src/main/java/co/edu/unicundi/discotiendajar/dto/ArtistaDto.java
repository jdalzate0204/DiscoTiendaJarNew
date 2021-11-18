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
    
    @NotNull(message = "idSexo es obligatorio")
    private Integer idSexo;
    
    @NotNull(message = "idGeneroMusical es obligatorio")
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
    

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the idSexo
     */
    public Integer getIdSexo() {
        return idSexo;
    }

    /**
     * @param idSexo the idSexo to set
     */
    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    /**
     * @return the idGeneroMusical
     */
    public Integer getIdGeneroMusical() {
        return idGeneroMusical;
    }
    
     /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the generoMusical
     */
    public String getGeneroMusical() {
        return generoMusical;
    }

    /**
     * @param generoMusical the generoMusical to set
     */
    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }


    /**
     * @param idGeneroMusical the idGeneroMusical to set
     */
    public void setIdGeneroMusical(Integer idGeneroMusical) {
        this.idGeneroMusical = idGeneroMusical;
    }

      public Set<ConstraintViolation<ArtistaDto>> validar(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }
    
}
