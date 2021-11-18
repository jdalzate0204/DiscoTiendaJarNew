package co.edu.unicundi.discotiendajar.service.impl;

import co.edu.unicundi.discotiendajar.dto.AlbumDto;
import co.edu.unicundi.discotiendajar.entity.*;
import co.edu.unicundi.discotiendajar.exception.ResourceIllegalArgumentException;
import javax.ejb.*;
import co.edu.unicundi.discotiendajar.repository.IAlbumRepo;
import co.edu.unicundi.discotiendajar.service.IAlbumService;
import java.util.*;
import javax.validation.ConstraintViolation;

/**
 *
 * @author PAULA GUZMAN
 */
@Stateless
public class AlbumServiceImpl implements IAlbumService {

    @EJB
    public IAlbumRepo repo;
    
    @Override
    public void guardar(AlbumDto obj) throws ResourceIllegalArgumentException, CloneNotSupportedException {        
        HashMap<String, String> errores = new HashMap();
        
        for (ConstraintViolation error: obj.validar())
            errores.put(error.getPropertyPath().toString(), error.getMessage());

        if (errores.size() > 0)
            throw new ResourceIllegalArgumentException(errores.toString());
        else {
            int contador = this.repo.validarExistenciaAlbum(obj.getNombre());
            
            if (contador == 0) {
                Artista artista = new Artista();
                artista.setId(obj.getIdArtista());

                Album album = new Album();
                album.setNombre(obj.getNombre());
                album.setImagen(obj.getImagen());
                album.setDescripcion(obj.getDescripcion());
                album.setFechaLanzamiento(obj.getFechaLanzamiento());
                album.setPrecio(obj.getPrecio());
                album.setArtista(artista);

                this.repo.guardar(album);
            } else
                throw new CloneNotSupportedException("Álbum ya registrado");  
        }
    }

    @Override
    public List<Album> listar() {
        return this.repo.listarTodos();
    }

    @Override
    public Album listarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Album obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Album> listarSelect() {
        return this.repo.listarSelect();
    }
}
