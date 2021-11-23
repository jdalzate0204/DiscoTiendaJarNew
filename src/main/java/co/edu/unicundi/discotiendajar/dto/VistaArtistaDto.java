package co.edu.unicundi.discotiendajar.dto;

/**
 *
 * @author acer
 */
public class VistaArtistaDto {
    private Integer id;
    private String nombre;
    private String nacionalidad;
    private String sexo;
    private String generoMusical;
    private Integer CantidadAlbumes;

    public VistaArtistaDto() {
    }

    public VistaArtistaDto(String nombre, String nacionalidad, String sexo, String generoMusical, Integer CantidadAlbumes) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.generoMusical = generoMusical;
        this.CantidadAlbumes = CantidadAlbumes;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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

    public Integer getCantidadAlbumes() {
        return CantidadAlbumes;
    }

    public void setCantidadAlbumes(Integer CantidadAlbumes) {
        this.CantidadAlbumes = CantidadAlbumes;
    }
}
