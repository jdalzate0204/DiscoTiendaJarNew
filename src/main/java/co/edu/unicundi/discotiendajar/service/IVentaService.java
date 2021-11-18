package co.edu.unicundi.discotiendajar.service;

import co.edu.unicundi.discotiendajar.entity.Pago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author acer
 */
@Local
public interface IVentaService {
    public List<Pago> obtenerPago();
}
