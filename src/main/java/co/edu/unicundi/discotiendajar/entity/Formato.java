package co.edu.unicundi.discotiendajar.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author acer
 */
@Entity
@Table (name = "formato", schema = "adicional")

@NamedQueries({
    @NamedQuery(name = "Formato.Listar", query = "SELECT NEW co.edu.unicundi.discotiendajar.dto.Adicional(f.id, f.descripcion)"
                                                + " FROM Formato f")
})
public class Formato implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "descripcion", nullable = false, length = 3)
    private String descripcion;
    
    @OneToOne(mappedBy = "formato")
    private Cancion cancion;

    public Formato() {
    }

    public Formato(String descripcion, Cancion cancion) {
        this.descripcion = descripcion;
        this.cancion = cancion;
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

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }
}
