package co.edu.unicundi.discotiendajar.service;

import co.edu.unicundi.discotiendajar.dto.TokenDto;
import co.edu.unicundi.discotiendajar.entity.Administrador;
import co.edu.unicundi.discotiendajar.exception.*;
import javax.ejb.Local;

/**
 *
 * @author ALEJANDRA
 */
@Local
public interface IAdministradorService {
    public TokenDto login(Administrador obj)throws NoAutorizationException;
    public void eliminar(Integer id) throws ResourceNotFoundException;
    public int validarToken(String token);
}
