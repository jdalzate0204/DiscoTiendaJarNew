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
      Cancion cancion = em.find(Cancion.class, id);
      return cancion;        
    }

    @Override
    public void editar(Cancion obj) {
          Query query = em.createNamedQuery("Cancion.Editar", Album.class);
        query.setParameter("nombre", obj.getNombre());
        query.setParameter("descripcion", obj.getDescripcion());
        query.setParameter("duracion", obj.getDuracion());
        query.setParameter("colaboraciones", obj.getColaboraciones());
        query.setParameter("precio", obj.getPrecio());
        query.setParameter("id", obj.getId());
        query.executeUpdate();
    }

    @Override
    public void eliminar(Cancion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cancion> listarCancionIdAlbum(Integer idAlbum) {
        TypedQuery<Cancion> query = em.createNamedQuery("Cancion.ListarId", Cancion.class);
        query.setParameter("id", idAlbum);
        return query.getResultList();
    }

    @Override
    public List<Cancion> listarIdCancion(Integer id) {
         TypedQuery<Cancion> query = em.createNamedQuery("Cancion.ListarPorId", Cancion.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<Cancion> listarSelect(Integer id) {
       TypedQuery<Cancion> query = em.createNamedQuery("Cancion.ListarSelect", Cancion.class);
       query.setParameter("id", id);
       return query.getResultList();
    }
}
