package co.edu.unicundi.discotiendajar.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author acer
 */
@Entity
@Table (name = "venta", schema = "tienda")

@NamedQueries({
    @NamedQuery(name = "Ventas.ListarHistorial", query = "SELECT NEW co.edu.unicundi.discotiendajar.dto.VentaDto "
            + "(v.id, v.nombreCliente, v.celular, v.correo, v.direccion, v.fechaCompra, v.cantidadArticulos, v.total, v.pago.descripcion) "
            + "FROM Venta v ORDER BY v.id")
})
public class Venta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_cliente", nullable = false, length = 30)
    private String nombreCliente;

    @Column(name = "celular", nullable = false, length = 10)
    private String celular;

    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    
    @Column(name = "fecha_compra", nullable = false, length = 20)
    private String fechaCompra;
    
    @Column(name = "cantidad_articulos", nullable = false, length = 20)
    private Integer cantidadArticulos;
    
    @Column(name = "total", nullable = false, length = 20)
    private Double total;
    
    @OneToOne
    @JoinColumn(name = "id_pago", nullable = false)
    private Pago pago;

    public Venta() {
    }

    public Venta(String nombreCliente,  String celular, String correo, String direccion, String fechaCompra, Integer cantidadArticulos, Double total, Pago pago) {
        this.nombreCliente = nombreCliente;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
        this.fechaCompra = fechaCompra;
        this.cantidadArticulos = cantidadArticulos;
        this.total = total;
        this.pago = pago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Integer getCantidadArticulos() {
        return cantidadArticulos;
    }

    public void setCantidadArticulos(Integer cantidadArticulos) {
        this.cantidadArticulos = cantidadArticulos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @XmlTransient
    @JsonIgnore
    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}