package co.edu.unicundi.discotiendajar.service.impl;

import co.edu.unicundi.discotiendajar.dto.CancionDto;
import co.edu.unicundi.discotiendajar.entity.*;
import co.edu.unicundi.discotiendajar.exception.ResourceIllegalArgumentException;
import co.edu.unicundi.discotiendajar.repository.ICancionRepo;
import co.edu.unicundi.discotiendajar.service.ICancionService;
import java.util.HashMap;
import java.util.List;
import javax.ejb.*;
import javax.validation.ConstraintViolation;

/**
 *
 * @author acer
 */
@Stateless
public class CancionServiceImpl implements ICancionService {

    @EJB
    public ICancionRepo repo;
    
    @Override
    public List<Formato> obtenerFormato() {
        return this.repo.obtenerFormato();
    }
    
    @Override
    public void guardar(CancionDto obj) throws ResourceIllegalArgumentException, CloneNotSupportedException {
        HashMap<String, String> errores = new HashMap();
        
        for (ConstraintViolation error: obj.validar())
            errores.put(error.getPropertyPath().toString(), error.getMessage());

        if (errores.size() > 0)
            throw new ResourceIllegalArgumentException(errores.toString());
        else {
            int contador = this.repo.validarExistenciaCancion(obj.getNombre());
            
            if (contador == 0) {
                Album album = new Album();
                album.setId(obj.getIdAlbum());

                Formato formato = new Formato();
                formato.setId(obj.getIdFormato());

                Cancion cancion = new Cancion();
                cancion.setNombre(obj.getNombre());
                cancion.setDescripcion(obj.getDescripcion());
                cancion.setDuracion(obj.getDuracion());
                cancion.setFormato(formato);
                cancion.setColaboraciones(obj.getColaboraciones());
                cancion.setPrecio(obj.getPrecio());
                cancion.setAlbum(album);

                this.repo.guardar(cancion);
            } else
                throw new CloneNotSupportedException("Canción ya registrada"); 
        }
    }

    @Override
    public List<Cancion> listar() {
        return this.repo.listarTodos();
    }

    @Override
    public Cancion listarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Cancion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
