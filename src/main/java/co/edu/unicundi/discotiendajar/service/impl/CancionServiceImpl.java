package co.edu.unicundi.discotiendajar.service.impl;

import co.edu.unicundi.discotiendajar.dto.CancionDto;
import co.edu.unicundi.discotiendajar.entity.*;
import co.edu.unicundi.discotiendajar.exception.ResourceIllegalArgumentException;
import co.edu.unicundi.discotiendajar.exception.ResourceNotFoundException;
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
    public  List<Cancion> listarPorId(Integer id) throws ResourceNotFoundException{
       List<Cancion> cancion = this.repo.listarIdCancion(id);
        if(cancion.size()==1){
            return cancion;
        }else{
           throw new ResourceNotFoundException("Cancion no encontrado");
        } 
    }

    @Override
    public void editar(CancionDto obj)throws  ResourceIllegalArgumentException, CloneNotSupportedException {
        HashMap<String, String> errores = new HashMap();
        
        for (ConstraintViolation error: obj.validar())
            errores.put(error.getPropertyPath().toString(), error.getMessage());

        if (errores.size() > 0)
            throw new ResourceIllegalArgumentException(errores.toString());
        else {
            int contador = this.repo.validarExistenciaCancion(obj.getNombre());
            Cancion cancion1=this.repo.listarPorId(obj.getId());
            
            if ((contador == 0)||(cancion1.getId()==obj.getId())) {
                
                Cancion cancion = new Cancion();
                cancion.setNombre(obj.getNombre());
                cancion.setDescripcion(obj.getDescripcion());
                cancion.setDuracion(obj.getDuracion());
                cancion.setColaboraciones(obj.getColaboraciones());
                cancion.setPrecio(obj.getPrecio());
                cancion.setId(obj.getId());
                this.repo.editar(cancion);
            } else
                throw new CloneNotSupportedException("el nombre de la Canción ya registrada"); 
        }
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cancion> listarCancionIdAlbum(Integer idAlbum) throws ResourceNotFoundException{
        List<Cancion> cancion = this.repo.listarCancionIdAlbum(idAlbum);
        if(cancion != null){
            return cancion;
        }else{
           throw new ResourceNotFoundException("Album sin canciones");
        }   
    }
}
