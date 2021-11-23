package co.edu.unicundi.discotiendajar.service;

import co.edu.unicundi.discotiendajar.dto.ArtistaDto;
import co.edu.unicundi.discotiendajar.entity.*;
import co.edu.unicundi.discotiendajar.exception.ResourceIllegalArgumentException;
import co.edu.unicundi.discotiendajar.exception.ResourceNotFoundException;
import co.edu.unicundi.discotiendajar.view.VistaArtista;
import java.util.List;


/**
 *
 * @author acer
 */
//@Local
public interface IArtistaService {
    public void guardar(ArtistaDto obj)throws ResourceIllegalArgumentException,CloneNotSupportedException ;
    public List<Artista> listar();
    public List<Artista> listarPorId(Integer id)throws ResourceNotFoundException;
    public void editar(ArtistaDto obj)throws ResourceIllegalArgumentException,CloneNotSupportedException;
    public void eliminar(Integer id);
    public List<Sexo> obtenerSexo();
    public List<GeneroMusical> obtenerGenero();
    public List<Artista> listarSelect();
    public List<VistaArtista> vista();
}
