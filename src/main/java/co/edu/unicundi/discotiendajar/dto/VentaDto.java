package co.edu.unicundi.discotiendajar.dto;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;

/**
 *
 * @author acer
 */
public class VentaDto {
    private Integer id;
    
    @NotNull(message = "nombreCliente es obligatorio")
    @Size(min = 3, max = 50, message = "nombreCliente debe estar entre 3 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "¡Solo se admiten letras!")
    private String nombreCliente;
    
    @NotNull(message = "celular es obligatorio")
    @Size(min = 10, max = 10, message = "celular debe tener 10 caracteres")
    @Pattern(regexp = "^\\d+$", message = "¡Solo se admiten numeros!")
    private String celular;
    
    @NotNull (message = "correo es obligatorio")
    @Size(max = 50, message = "correo no debe superar los 50 caracteres")
    private String correo;
    
    @NotNull (message = "direccion es obligatorio")
    @Size(max = 50, message = "direccion no debe superar los 50 caracteres")
    private String direccion;

    private String fechaCompra;
    
    private Integer cantidadArticulos;
    
    private Double total;
    
    private Integer idPago;
    
    private String pago;

    public VentaDto() {
    }

    public VentaDto(Integer id, String nombreCliente, String celular, String correo, String direccion, String fechaCompra, Integer cantidadArticulos, Double total, Integer idPago, String pago) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
        this.fechaCompra = fechaCompra;
        this.cantidadArticulos = cantidadArticulos;
        this.total = total;
        this.idPago = idPago;
        this.pago = pago;
    }

    public VentaDto(Integer id, String nombreCliente, String celular, String correo, String direccion, String fechaCompra, Integer cantidadArticulos, Double total, String pago) {
        this.id = id;
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

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }
    
    public Set<ConstraintViolation<VentaDto>> validar(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }
}
