package co.edu.unicundi.discotiendajar.repository.impl;

import co.edu.unicundi.discotiendajar.entity.Album;
import java.util.List;
import javax.persistence.*;
import co.edu.unicundi.discotiendajar.repository.IAlbumRepo;
import co.edu.unicundi.discotiendajar.view.VistaAlbum;
import javax.ejb.Stateless;

/**
 *
 * @author PAULA GUZMAN
 */
@Stateless
public class AlbumRepoImpl implements IAlbumRepo {
 
    @PersistenceContext(unitName = "conexionDiscoTienda")
    private EntityManager em;

    @Override
    public void guardar(Album obj) {
        this.em.persist(obj);
    }

    @Override
    public int validarExistenciaAlbum(String nombre) {
        Query query = em.createNamedQuery("Album.ContarNombre");
        query.setParameter("nombre", nombre);
        Number validador = (Number) query.getSingleResult();
        int respuesta = validador.intValue();
        return respuesta;
    }

    @Override
    public List<Album> listarTodos() {
        TypedQuery<Album> query = em.createNamedQuery("Album.ListarTodos", Album.class);
        return query.getResultList();
    }

    @Override
    public Album listarPorId(Integer id) {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Album obj) {
        Query query = em.createNamedQuery("Album.Editar", Album.class);
        query.setParameter("nombre", obj.getNombre());
        query.setParameter("imagen", obj.getImagen());
        query.setParameter("descripcion", obj.getDescripcion());
        query.setParameter("fechaLanzamiento", obj.getFechaLanzamiento());
        query.setParameter("precio", obj.getPrecio());
        query.setParameter("id", obj.getId());
        query.executeUpdate();
    }

    @Override
    public void eliminar(Album obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public List<Album> listarSelect() {
        TypedQuery<Album> query = em.createNamedQuery("Album.ListarSelect", Album.class);
        return query.getResultList();
    }

    @Override
    public List<Album> listarId(Integer id) {
       TypedQuery<Album> query = em.createNamedQuery("Album.ListarId", Album.class);
       query.setParameter("id", id);
       return query.getResultList();
    }

    @Override
    public List<VistaAlbum> vista() {
        TypedQuery<VistaAlbum> query = em.createNamedQuery("VistaAlbum.Listar", VistaAlbum.class);
        return query.getResultList();
    }
}
