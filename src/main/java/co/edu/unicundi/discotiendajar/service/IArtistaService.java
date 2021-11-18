package co.edu.unicundi.discotiendajar.service;

import co.edu.unicundi.discotiendajar.dto.ArtistaDto;
import co.edu.unicundi.discotiendajar.entity.*;
import co.edu.unicundi.discotiendajar.exception.ResourceIllegalArgumentException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author acer
 */
//@Local
public interface IArtistaService {
    public void guardar(ArtistaDto obj)throws ResourceIllegalArgumentException,CloneNotSupportedException ;
    public List<Artista> listar();
    public Artista listarPorId(Integer id);
    public void editar(Artista obj);
    public void eliminar(Integer id);
    public List<Sexo> obtenerSexo();
    public List<GeneroMusical> obtenerGenero();
    public List<Artista> listarSelect();
}
