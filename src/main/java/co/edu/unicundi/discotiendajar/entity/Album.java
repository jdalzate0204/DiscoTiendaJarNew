package co.edu.unicundi.discotiendajar.entity;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author acer
 */
@Entity
@Table (name = "album", schema = "principal")

@NamedQueries({
    @NamedQuery(name = "Album.ContarNombre", query = "SELECT COUNT(a.nombre) FROM Album a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Album.ListarTodos", query = "SELECT NEW co.edu.unicundi.discotiendajar.dto.AlbumDto"
            + "(al.id, al.nombre, al.imagen, al.descripcion, al.fechaLanzamiento, al.precio, al.artista.nombre) FROM Album al"),
    @NamedQuery(name = "Album.ListarSelect", query = "SELECT NEW co.edu.unicundi.discotiendajar.dto.AlbumDto(a.id, a.nombre) FROM Album a")
})
public class Album implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    
    @Column(name = "imagen", nullable = true)
    private String imagen;
    
    @Column(name = "descripcion", nullable = false, length = 150)
    private String descripcion;

    @Column(name = "fecha_lanzamiento", nullable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    private String fechaLanzamiento;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;
    
    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Cancion> cancion;

    public Album() {
    }

    public Album(String nombre, String imagen, String descripcion, String fechaLanzamiento, Double precio, Artista artista, List<Cancion> cancion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.precio = precio;
        this.artista = artista;
        this.cancion = cancion;
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

    @XmlTransient
    @JsonIgnore
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) { 
        this.artista = artista;
    }

    public List<Cancion> getCancion() {
        return cancion;
    }

    public void setCancion(List<Cancion> cancion) {
        this.cancion = cancion;
    }
}
