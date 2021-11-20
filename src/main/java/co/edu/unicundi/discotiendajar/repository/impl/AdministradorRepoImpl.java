
package co.edu.unicundi.discotiendajar.repository.impl;

import co.edu.unicundi.discotiendajar.entity.Administrador;
import co.edu.unicundi.discotiendajar.entity.Token;
import co.edu.unicundi.discotiendajar.repository.IAdministradorRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author ALEJANDRA
 */
@Stateless
public class AdministradorRepoImpl implements IAdministradorRepo {
    @PersistenceContext(unitName="conexionDiscoTienda")
    private EntityManager em;

    @Override
    public List<Administrador> login(String usuario, String contrasena) {
        Query query = em.createNamedQuery("Administrador.Login",Administrador.class);
        query.setParameter("usuario", usuario);
        query.setParameter("contrasena", contrasena);
        List<Administrador> administrador=query.getResultList();
        return administrador;
    }

    @Override
    public void guardar(Token obj) {
        this.em.persist(obj);
    }

    @Override
    public List<Token> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Token listarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Token obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Token obj) {
         this.em.remove(obj);
    }

    @Override
    public int validarToken(Integer id) {
       Query query = em.createNamedQuery("Token.BuscarToken");
       query.setParameter("idAdmin", id);
       Number validador = (Number) query.getSingleResult();
       int respuesta = validador.intValue();
       return respuesta;
    }

    @Override
    public void eliminarToken(Integer id) {
      this.em.createNamedQuery("Token.Eliminar").setParameter("idAdmin", id).executeUpdate();
    }

    @Override
    public int validarExistenciaToken(String token) {
       Query query = em.createNamedQuery("Token.ValidarToken");
       query.setParameter("token", token);
       Number validador = (Number) query.getSingleResult();
       int respuesta = validador.intValue();
       return respuesta;
    }

}
