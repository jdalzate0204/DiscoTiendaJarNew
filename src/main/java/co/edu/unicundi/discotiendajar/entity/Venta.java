package co.edu.unicundi.discotiendajar.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author acer
 */
@Entity
@Table (name = "venta", schema = "tienda")
public class Venta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "nombreCliente es obligatorio")
    @Size(min = 3, max = 30, message = "nombreCliente debe estar entre 3 y 30 caracteres")
    @Pattern(regexp = "^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "¡Solo se admiten letras!")
    @Column(name = "nombre_cliente", nullable = false, length = 30)
    private String nombreCliente;
    
    @NotNull(message = "apellidoCliente es obligatorio")
    @Size(min = 4, max = 30, message = "apellidoCliente debe estar entre 4 y 30 caracteres")
    @Pattern(regexp = "^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "¡Solo se admiten letras!")
    @Column(name = "apellido_cliente", nullable = false, length = 30)
    private String apellidoCliente;
    
    @NotNull(message = "celular es obligatorio")
    @Size(min = 10, max = 10, message = "celular debe tener 10 caracteres")
    @Pattern(regexp = "^\\d+$", message = "¡Solo se admiten numeros!")
    @Column(name = "celular", nullable = false, length = 10)
    private String celular;
    
    @NotNull (message = "correo es obligatorio")
    @Size(max = 50, message = "correo no debe superar los 50 caracteres")
    @Pattern (regexp = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$", message = "¡Ingrese un formato valido!")
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;
    
    @NotNull (message = "direccion es obligatorio")
    @Size(max = 50, message = "direccion no debe superar los 50 caracteres")
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    
    @Column(name = "fecha_compra", nullable = false, length = 20)
    private Timestamp fechaCompra;
    
    @Column(name = "cantidad_articulos", nullable = false, length = 20)
    private Integer cantidadArticulos;
    
    @Column(name = "total", nullable = false, length = 20)
    private Double total;
    
    @OneToOne
    @JoinColumn(name = "id_pago", nullable = false)
    private Pago pago;

    public Venta() {
    }

    public Venta(String nombreCliente, String apellidoCliente, String celular, String correo, String direccion, Timestamp fechaCompra, Integer cantidadArticulos, Double total, Pago pago) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
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

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
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

    public Timestamp getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Timestamp fechaCompra) {
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

    //@XmlTransient
    @JsonIgnore
    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}
