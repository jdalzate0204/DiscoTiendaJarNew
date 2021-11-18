package co.edu.unicundi.discotiendajar.service.impl;

import co.edu.unicundi.discotiendajar.dto.ArtistaDto;
import co.edu.unicundi.discotiendajar.entity.*;
import co.edu.unicundi.discotiendajar.exception.ResourceIllegalArgumentException;
import co.edu.unicundi.discotiendajar.repository.IArtistaRepo;
import co.edu.unicundi.discotiendajar.service.IArtistaService;
import java.util.HashMap;
import java.util.List;
import javax.ejb.*;
import javax.validation.ConstraintViolation;

/**
 *
 * @author acer
 */
@Stateless
public class ArtistaServiceImpl implements IArtistaService{
    
    @EJB
    public IArtistaRepo repo;
    
    @Override
    public List<Sexo> obtenerSexo() {
        return this.repo.obtenerSexo();
    }

    @Override
    public List<GeneroMusical> obtenerGenero() {
        return this.repo.obtenerGenero();
    }
    
    @Override
    public void guardar(ArtistaDto obj)throws ResourceIllegalArgumentException,CloneNotSupportedException  {
        HashMap<String, String> errores = new HashMap();
        
        for (ConstraintViolation error: obj.validar())
            errores.put(error.getPropertyPath().toString(), error.getMessage());

        if (errores.size() > 0)
            throw new ResourceIllegalArgumentException(errores.toString());
        else {
            int contador = this.repo.validarExistenciaArtista(obj.getNombre());
            
             if (contador == 0) {
            
                Sexo sexo=new Sexo();
                sexo.setId(obj.getIdSexo());
                GeneroMusical genero=new GeneroMusical();
                genero.setId(obj.getIdGeneroMusical());
                Artista artista=new Artista();
                artista.setFechaNacimiento(obj.getFechaNacimiento());
                artista.setGeneroMusical(genero);
                artista.setNacionalidad(obj.getNacionalidad());
                artista.setNombre(obj.getNombre());
                artista.setSexo(sexo);

                this.repo.guardar(artista);
            }else
                throw new CloneNotSupportedException("el Artista ya esta registrado"); 
        }
    }

    @Override
    public List<Artista> listar() {
      return this.repo.listarTodos();
    }

    @Override
    public Artista listarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Artista obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public List<Artista> listarSelect() {
        return this.repo.listarSelect();
    }
}
