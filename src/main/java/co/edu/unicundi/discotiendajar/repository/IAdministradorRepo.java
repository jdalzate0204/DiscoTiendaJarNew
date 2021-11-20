
package co.edu.unicundi.discotiendajar.repository;

import co.edu.unicundi.discotiendajar.entity.Administrador;
import co.edu.unicundi.discotiendajar.entity.Token;
import co.edu.unicundi.discotiendajar.exception.ResourceNotFoundException;
import java.util.List;



/**
 *
 * @author ALEJANDRA
 */
public interface IAdministradorRepo extends ICrud<Token, Integer>{
    public List<Administrador> login(String usuario,String contrasena);
    public int validarToken(Integer id);
    public void eliminarToken(Integer id);
    public int validarExistenciaToken(String token);
}
