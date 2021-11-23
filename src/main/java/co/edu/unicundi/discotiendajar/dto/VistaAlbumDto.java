package co.edu.unicundi.discotiendajar.dto;

/**
 *
 * @author acer
 */
public class VistaAlbumDto {
    private Integer id;
    private String nombre;
    private String artista;
    private String fechaLanzamiento;
    private Integer cantidadCanciones;

    public VistaAlbumDto() {
    }

    public VistaAlbumDto(String nombre, String artista, String fechaLanzamiento, Integer cantidadCanciones) {
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
