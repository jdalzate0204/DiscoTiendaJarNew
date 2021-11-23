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
@Table(name = "vista_albumes", schema = "principal")

@NamedQueries({
    @NamedQuery(name = "VistaAlbum.Listar", query = "SELECT NEW co.edu.unicundi.discotiendajar.dto.VistaAlbumDto"
            + "(v.nombre, v.artista, v.fechaLanzamiento, v.cantidadCanciones) FROM VistaAlbum v")
})
public class VistaAlbum implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre_album", insertable = false, updatable = false, length = 30)
    private String nombre;
    
    @Column(name = "artista", insertable = false, updatable = false, length = 30)
    private String artista;
    
    @Column(name = "fecha_lanzamiento", insertable = false, updatable = false)
    private String fechaLanzamiento;
    
    @Column(name = "cantidad_canciones", insertable = false, updatable = false, length = 30)
    private Integer cantidadCanciones;

    public VistaAlbum() {
    }

    public VistaAlbum(String nombre, String artista, String fechaLanzamiento, Integer cantidadCanciones) {
        this.nombre = nombre;
        this.artista = artista;
        this.fechaLanzamiento = fechaLanzamiento;
        this.cantidadCanciones = cantidadCanciones;
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

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Integer getCantidadCanciones() {
        return cantidadCanciones;
    }

    public void setCantidadCanciones(Integer cantidadCanciones) {
        this.cantidadCanciones = cantidadCanciones;
    }
}
