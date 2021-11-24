package co.edu.unicundi.discotiendajar.repository;

import co.edu.unicundi.discotiendajar.entity.*;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author acer
 */
@Local
public interface IVentaRepo{
    public List<Pago> obtenerPago();
    public List<Album> listarCatalogo();
    public void guardarCarrito(Carrito obj);
    public List<Carrito> listarCarrito();
    public void guardarHistorial(Venta obj);
    public void editarEstado(Boolean estado);
}
