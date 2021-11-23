package co.edu.unicundi.discotiendajar.service;

import co.edu.unicundi.discotiendajar.dto.CancionDto;
import co.edu.unicundi.discotiendajar.entity.*;
import co.edu.unicundi.discotiendajar.exception.ResourceIllegalArgumentException;
import co.edu.unicundi.discotiendajar.exception.ResourceNotFoundException;
import java.util.List;

/**
 *
 * @author acer
 */
//@Local
public interface ICancionService {
    public void guardar(CancionDto obj) throws ResourceIllegalArgumentException, CloneNotSupportedException;
    public List<Cancion> listar();
    public Cancion listarPorId(Integer id);
    public void editar(Cancion obj)throws  CloneNotSupportedException;
    public void eliminar(Integer id);
    public List<Formato> obtenerFormato();
    public List<Cancion> listarId(Integer id)throws ResourceNotFoundException;
   
}
