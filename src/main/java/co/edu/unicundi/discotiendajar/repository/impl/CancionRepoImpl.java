package co.edu.unicundi.discotiendajar.repository.impl;

import co.edu.unicundi.discotiendajar.entity.*;
import co.edu.unicundi.discotiendajar.repository.ICancionRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author acer
 */
@Stateless
public class CancionRepoImpl implements ICancionRepo {

    @PersistenceContext(unitName = "conexionDiscoTienda")
    private EntityManager em;

    @Override
    public List<Formato> obtenerFormato() {
        TypedQuery<Formato> query = em.createNamedQuery("Formato.Listar", Formato.class);
        return query.getResultList();
    }
    
    @Override
    public void guardar(Cancion obj) {
        this.em.persist(obj);
    }    

    @Override
    public int validarExistenciaCancion(String nombre) {
        Query query = em.createNamedQuery("Cancion.ContarNombre");
        query.setParameter("nombre", nombre);
        Number validador = (Number) query.getSingleResult();
        int respuesta = validador.intValue();
        return respuesta;
    }

    @Override
    public List<Cancion> listarTodos() {
        TypedQuery<Cancion> query = em.createNamedQuery("Cancion.ListarTodos", Cancion.class);
        return query.getResultList();
    }

    @Override
    public Cancion listarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Cancion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Cancion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
