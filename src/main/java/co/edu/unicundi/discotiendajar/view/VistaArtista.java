package co.edu.unicundi.discotiendajar.view;

import java.io.Serializable;
import javax.persistence.*;
import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 *
 * @author acer
 */
@Entity
@Immutable
@Table(name = "vista_artista", schema = "principal")

@NamedQueries({
    @NamedQuery(name = "VistaArtista.Listar", query = "SELECT NEW co.edu.unicundi.discotiendajar.dto.VistaArtistaDto"
            + "(v.nombre, v.nacionalidad, v.sexo, v.generoMusical, v.CantidadAlbumes) FROM VistaArtista v")
})
public class VistaArtista implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre_artista", insertable = false, updatable = false, length = 30)
    private String nombre;
    
    @Column(name = "nacionalidad", insertable = false, updatable = false, length = 30)
    private String nacionalidad;
    
    @Column(name = "sexo", insertable = false, updatable = false, length = 9)
    private String sexo;
    
    @Column(name = "genero_musical", insertable = false, updatable = false, length = 30)
    private String generoMusical;
    
    @Column(name = "cantidad_albumes", insertable = false, updatable = false)
    private Integer CantidadAlbumes;

    public VistaArtista() {
    }

    public VistaArtista(String nombre, String nacionalidad, String sexo, String generoMusical, Integer CantidadAlbumes) {
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
