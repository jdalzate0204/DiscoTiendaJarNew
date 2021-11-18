package co.edu.unicundi.discotiendajar.repository;

import co.edu.unicundi.discotiendajar.entity.*;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author acer
 */
//@Local
public interface IArtistaRepo  extends ICrud<Artista, Integer>{
    public List<Sexo> obtenerSexo();
    public List<GeneroMusical> obtenerGenero();
    public int validarExistenciaArtista(String nombre);
    public List<Artista> listarSelect();
}
