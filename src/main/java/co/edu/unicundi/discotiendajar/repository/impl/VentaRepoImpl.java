package co.edu.unicundi.discotiendajar.repository.impl;

import co.edu.unicundi.discotiendajar.entity.Album;
import co.edu.unicundi.discotiendajar.entity.Carrito;
import co.edu.unicundi.discotiendajar.entity.Pago;
import co.edu.unicundi.discotiendajar.entity.Venta;
import co.edu.unicundi.discotiendajar.repository.IVentaRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author acer
 */
@Stateless
public class VentaRepoImpl implements IVentaRepo {
    
    @PersistenceContext(unitName = "conexionDiscoTienda")
    private EntityManager em;

    @Override
    public List<Pago> obtenerPago() {
        TypedQuery<Pago> query = em.createNamedQuery("Pago.Listar", Pago.class);
        return query.getResultList();
    }

    @Override
    public List<Album> listarCatalogo() {
        TypedQuery<Album> query = em.createNamedQuery("Album.ListarTodos", Album.class);
        return query.getResultList();
    }

    @Override
    public void guardarCarrito(Carrito obj) {
        this.em.persist(obj);
    }

    @Override
    public List<Carrito> listarCarrito() {
        TypedQuery<Carrito> query=em.createNamedQuery("Carrito.Select",Carrito.class);
        return query.getResultList();
    }

    @Override
    public void guardarHistorial(Venta obj) {
        this.em.persist(obj);
    }

    @Override
    public void editarEstado(Boolean estado) {
        Query query = em.createNamedQuery("Carrito.Editar", Carrito.class);
        query.setParameter("estado", estado);
        query.executeUpdate();
    }
    
}
