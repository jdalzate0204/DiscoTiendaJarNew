package co.edu.unicundi.discotiendajar.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author acer
 */
@Entity
@Table (name = "pago", schema = "adicional")

@NamedQueries({
    @NamedQuery(name = "Pago.Listar", query = "SELECT NEW co.edu.unicundi.discotiendajar.dto.Adicional(p.id, p.descripcion) FROM Pago p")
})
public class Pago implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "descripcion", nullable = false, length = 20)
    private String descripcion;

    @OneToOne(mappedBy = "pago")
    private Venta venta;

    public Pago() {
    }

    public Pago(String descripcion, Venta venta) {
        this.descripcion = descripcion;
        this.venta = venta;
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

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
