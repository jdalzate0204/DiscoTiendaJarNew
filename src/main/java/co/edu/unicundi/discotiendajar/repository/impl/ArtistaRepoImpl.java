package co.edu.unicundi.discotiendajar.repository.impl;

import co.edu.unicundi.discotiendajar.entity.*;
import co.edu.unicundi.discotiendajar.repository.IArtistaRepo;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Artista obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Artista obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
