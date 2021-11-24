package co.edu.unicundi.discotiendajar.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author acer
 */
@Entity
@Table (name = "carrito", schema = "tienda")
public class Carrito implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre_cancion", nullable = false, length = 30)
    private String cancion;
    
    @Column(name = "precio", nullable = false)
    private Integer precio;
    
    @Column(name = "album", nullable = false)
    private String album;
    
    @Column(name = "estado", nullable = false)
    private boolean estado;

    public Carrito() {
    }

    public Carrito(String cancion, Integer precio, String album, boolean estado) {
        this.cancion = cancion;
        this.precio = precio;
        this.album = album;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
