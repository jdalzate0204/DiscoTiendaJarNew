package co.edu.unicundi.discotiendajar.service;

import co.edu.unicundi.discotiendajar.entity.*;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author acer
 */
@Local
public interface IVentaService {
    public List<Pago> obtenerPago();
    public List<Album> listarCatalogo();
    public void guardarCarrito(Carrito obj);
    public List<Carrito> listarCarrito();
}
