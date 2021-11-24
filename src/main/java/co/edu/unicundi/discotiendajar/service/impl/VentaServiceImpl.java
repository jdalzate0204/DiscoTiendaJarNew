package co.edu.unicundi.discotiendajar.service.impl;

import co.edu.unicundi.discotiendajar.entity.Album;
import co.edu.unicundi.discotiendajar.entity.Carrito;
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

    @Override
    public List<Album> listarCatalogo() {
        return this.repo.listarCatalogo();
    }

    @Override
    public void guardarCarrito(Carrito obj) {
        this.repo.guardarCarrito(obj);
    }

    @Override
    public List<Carrito> listarCarrito() {
        return this.repo.listarCarrito();
    }
}
