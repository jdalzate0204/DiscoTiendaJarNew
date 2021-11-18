package co.edu.unicundi.discotiendajar.service;

import co.edu.unicundi.discotiendajar.dto.AlbumDto;
import co.edu.unicundi.discotiendajar.entity.Album;
import co.edu.unicundi.discotiendajar.exception.ResourceIllegalArgumentException;
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
    public Album listarPorId(Integer id);
    public void editar(Album obj);
    public void eliminar(Integer id);
    public List<Album> listarSelect();
}
