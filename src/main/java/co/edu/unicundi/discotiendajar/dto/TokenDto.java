
package co.edu.unicundi.discotiendajar.dto;

import co.edu.unicundi.discotiendajar.entity.Administrador;

/**
 *
 * @author ALEJANDRA
 */
public class TokenDto {

    private Integer id;
    private String token;
    private Administrador administrador;
    private Integer idAdministrador;

    public TokenDto() {
    }

    public TokenDto(Integer id, String token, Administrador administrador,Integer idAdministrador) {
        this.id = id;
        this.token = token;
        this.administrador = administrador;
        this.idAdministrador=idAdministrador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    
}
