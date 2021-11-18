package co.edu.unicundi.discotiendajar.service.impl;

import co.edu.unicundi.discotiendajar.entity.Pago;
import co.edu.unicundi.discotiendajar.repository.IVentaRepo;
import co.edu.unicundi.discotiendajar.service.IVentaService;
import java.util.List;
import javax.ejb.*;

/**
 *
 * @author acer
 */
@Stateless
public class VentaServiceImpl implements IVentaService {
    
    @EJB
    public IVentaRepo repo;

    @Override
    public List<Pago> obtenerPago() {
        return this.repo.obtenerPago();
    }
    
}
