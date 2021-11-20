package co.edu.unicundi.discotiendajar.service.impl;

import co.edu.unicundi.discotiendajar.dto.TokenDto;
import co.edu.unicundi.discotiendajar.entity.*;
import co.edu.unicundi.discotiendajar.exception.*;
import co.edu.unicundi.discotiendajar.repository.IAdministradorRepo;
import co.edu.unicundi.discotiendajar.service.IAdministradorService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.*;
import javax.ejb.*;

/**
 *
 * @author ALEJANDRA
 */
@Stateless
public class AdministradorServiceImpl implements IAdministradorService {
    
    @EJB
    public IAdministradorRepo repo;
   
    Administrador admin = new Administrador();
    
    @Override
    public TokenDto login(Administrador obj) throws NoAutorizationException {
        List<Administrador> administrador = this.repo.login(obj.getUsuario(),obj.getContrasena());
        
        if (administrador.size() == 1) {
            String key="E1BuRy$EHyw";
            long tiempo = System.currentTimeMillis();
            
            Map<String, Object> permisos=new HashMap<>();
            permisos.put("1","administrador");
            
            String jwt=Jwts.builder()
                    .signWith(SignatureAlgorithm.HS512,key)
                    .setSubject(obj.getUsuario())
                    .setIssuedAt(new Date(tiempo))
                    .setExpiration(new Date(tiempo + 2000000000))
                    .claim("permisos", permisos)
                    .compact();
            
            TokenDto token = new TokenDto();
            admin = null;
            
            for(Administrador administrador1:administrador){
                admin = administrador1;  
            }
            admin.setId(admin.getId());
            
            Token token1=new Token();
            token1.setAdministrador(admin);
            token1.setToken(jwt);
            this.repo.guardar(token1);
            token.setToken(token1.getToken());
            token.setId(admin.getId());
            return token;
        } else {
            throw new NoAutorizationException("Usuario y/o contrasena incorrecta");
        }
    }

    @Override
    public void eliminar(Integer id)throws ResourceNotFoundException {
        int valor = this.repo.validarToken(id);
        
        if (valor == 1) {
            this.repo.eliminarToken(id);
        } else {
            throw new ResourceNotFoundException("no hay token");
        }
    }

    @Override
    public int validarToken(String token) {
        return this.repo.validarExistenciaToken(token);
    }
}