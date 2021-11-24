package co.edu.unicundi.discotiendajar.service.impl;

import co.edu.unicundi.discotiendajar.dto.VentaDto;
import co.edu.unicundi.discotiendajar.entity.Album;
import co.edu.unicundi.discotiendajar.entity.Carrito;
import co.edu.unicundi.discotiendajar.entity.Pago;
import co.edu.unicundi.discotiendajar.entity.Venta;
import co.edu.unicundi.discotiendajar.exception.ResourceIllegalArgumentException;
import co.edu.unicundi.discotiendajar.repository.IVentaRepo;
import co.edu.unicundi.discotiendajar.service.IVentaService;
import java.util.HashMap;
import java.util.List;
import javax.ejb.*;
import javax.validation.ConstraintViolation;

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

    @Override
    public void guardarHistorial(VentaDto obj) throws ResourceIllegalArgumentException{
        HashMap<String, String> errores = new HashMap();
        
        for (ConstraintViolation error: obj.validar())
            errores.put(error.getPropertyPath().toString(), error.getMessage());

        if (errores.size() > 0)
            throw new ResourceIllegalArgumentException(errores.toString());
        else {
            Pago pago = new Pago();
            pago.setId(obj.getIdPago());
            
            Venta venta = new Venta();
            venta.setNombreCliente(obj.getNombreCliente());
            venta.setCelular(obj.getCelular());
            venta.setCorreo(obj.getCorreo());
            venta.setDireccion(obj.getDireccion());
            venta.setFechaCompra(obj.getFechaCompra());
            venta.setCantidadArticulos(obj.getCantidadArticulos());
            venta.setTotal(obj.getTotal());
            venta.setPago(pago);
            
            this.repo.guardarHistorial(venta);
        }
    }
}
