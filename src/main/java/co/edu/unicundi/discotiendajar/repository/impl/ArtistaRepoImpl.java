package co.edu.unicundi.discotiendajar.repository.impl;

import co.edu.unicundi.discotiendajar.entity.*;
import co.edu.unicundi.discotiendajar.repository.IArtistaRepo;
import co.edu.unicundi.discotiendajar.view.VistaArtista;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author acer
 */
@Stateless
public class ArtistaRepoImpl implements IArtistaRepo {
    
    @PersistenceContext(unitName = "conexionDiscoTienda")
    private EntityManager em;

    @Override
    public List<Sexo> obtenerSexo() {
        TypedQuery<Sexo> query = em.createNamedQuery("Sexo.Listar", Sexo.class);
        return query.getResultList();
    }

    @Override
    public List<GeneroMusical> obtenerGenero() {
        TypedQuery<GeneroMusical> query = em.createNamedQuery("GeneroMusical.Listar", GeneroMusical.class);
        return query.getResultList();
    }
    
    @Override
    public void guardar(Artista obj) {
      this.em.persist(obj);
    }
    
    @Override
    public List<Artista> listarTodos() {
        TypedQuery<Artista> query= em.createNamedQuery("Artista.ListarTodos",Artista.class);
        return query.getResultList();
    }

    @Override
    public Artista listarPorId(Integer id) {
      
        Artista artista = em.find(Artista.class, id);
        return artista;
    }

    @Override
    public void editar(Artista obj) {
     Query query = em.createNamedQuery("Artista.Editar", Album.class);
        query.setParameter("nombre", obj.getNombre());
        query.setParameter("fechaNacimiento", obj.getFechaNacimiento());
        query.setParameter("nacionalidad", obj.getNacionalidad());
        query.setParameter("id", obj.getId());
        query.executeUpdate();
    }

    @Override
    public void eliminar(Artista obj) {
     
    }    

    @Override
    public int validarExistenciaArtista(String nombre) {
       Query query = em.createNamedQuery("Artista.ContarNombre");
        query.setParameter("nombre", nombre);
        Number validador = (Number) query.getSingleResult();
        int respuesta = validador.intValue();
        return respuesta;
    }

    @Override
    public List<Artista> listarSelect() {
        TypedQuery<Artista> query = em.createNamedQuery("Artista.ListarSelect", Artista.class);
        return query.getResultList();
    }

    @Override
    public List<Artista> listarId(Integer id) {
       TypedQuery<Artista> query = em.createNamedQuery("Artista.ListarId", Artista.class);
       query.setParameter("id", id);
       return query.getResultList();
    }
    
    @Override
    public List<VistaArtista> vista() {
        TypedQuery<VistaArtista> query = em.createNamedQuery("VistaArtista.Listar", VistaArtista.class);
        return query.getResultList();
    }
}
