package co.edu.unicundi.discotiendajar.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author acer
 */
@Entity
@Table (name = "cancion", schema = "principal")

@NamedQueries({
    @NamedQuery(name = "Cancion.ContarNombre", query = "SELECT COUNT(c.nombre) FROM Cancion c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cancion.ListarTodos", query = "SELECT NEW co.edu.unicundi.discotiendajar.dto.CancionDto"
            + "(c.id, c.nombre, c.descripcion, c.duracion, c.colaboraciones, c.precio, c.album.nombre, c.formato.descripcion) FROM Cancion c")
})
public class Cancion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 150)
    private String descripcion;

    @Column(name = "duracion", nullable = false)
    private String duracion;

    @Column(name = "colaboraciones", nullable = true)
    private String colaboraciones;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_album", nullable = false)
    private Album album;
    
    @OneToOne
    @JoinColumn(name = "id_formato", nullable = false)
    private Formato formato;

    public Cancion() {
    }

    public Cancion(String nombre, String descripcion, String duracion, String colaboraciones, Double precio, Album album, Formato formato) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.colaboraciones = colaboraciones;
        this.precio = precio;
        this.album = album;
        this.formato = formato;
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

    //@XmlTransient
    @JsonIgnore
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    //@XmlTransient
    @JsonIgnore
    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }
}
