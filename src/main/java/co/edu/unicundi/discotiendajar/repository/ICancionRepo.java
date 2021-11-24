package co.edu.unicundi.discotiendajar.repository;

import co.edu.unicundi.discotiendajar.entity.*;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author acer
 */
@Local
public interface ICancionRepo  extends ICrud<Cancion, Integer>{
    public List<Formato> obtenerFormato();
    public int validarExistenciaCancion(String nombre);
    public List<Cancion> listarCancionIdAlbum(Integer idAlbum);
    public List<Cancion> listarIdCancion(Integer id);
}
