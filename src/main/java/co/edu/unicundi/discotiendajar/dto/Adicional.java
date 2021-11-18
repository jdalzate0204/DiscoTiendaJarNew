package co.edu.unicundi.discotiendajar.dto;

/**
 *
 * @author acer
 */
public class Adicional {
    private Integer id;
    private String descripcion;

    public Adicional() {
    }

    public Adicional(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
