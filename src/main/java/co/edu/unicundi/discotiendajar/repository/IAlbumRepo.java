package co.edu.unicundi.discotiendajar.repository;

import co.edu.unicundi.discotiendajar.entity.Album;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PAULA GUZMAN
 */
@Local
public interface IAlbumRepo extends ICrud<Album, Integer> {
    public int validarExistenciaAlbum(String nombre);
    public List<Album> listarSelect();
}
