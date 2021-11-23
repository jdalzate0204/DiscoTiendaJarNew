package co.edu.unicundi.discotiendajar.service;

import co.edu.unicundi.discotiendajar.dto.AlbumDto;
import co.edu.unicundi.discotiendajar.entity.Album;
import co.edu.unicundi.discotiendajar.exception.ResourceIllegalArgumentException;
import co.edu.unicundi.discotiendajar.exception.ResourceNotFoundException;
import co.edu.unicundi.discotiendajar.view.VistaAlbum;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PAULA GUZMAN
 */
@Local
public interface IAlbumService {
    public void guardar(AlbumDto obj) throws ResourceIllegalArgumentException, CloneNotSupportedException;
    public List<Album> listar();
    public List<Album> listarPorId(Integer id)throws ResourceNotFoundException;
    public void editar(AlbumDto obj)throws  ResourceIllegalArgumentException, CloneNotSupportedException ;
    public void eliminar(Integer id);
    public List<Album> listarSelect();
    public List<VistaAlbum> vista();
}
