package co.edu.unicundi.discotiendajar.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 *
 * @author acer
 */
@Entity
@Table (name = "administrador", schema = "principal")
@NamedQueries({
    @NamedQuery(name="Administrador.Login",query="SELECT a FROM Administrador a WHERE a.usuario= :usuario AND a.contrasena= :contrasena"),
    
})
public class Administrador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "usuario", nullable = false, length = 15)
    private String usuario;
    
    @Column(name = "contrasena", nullable = false, length = 30)
    private String contrasena;
        
    @OneToOne(mappedBy = "administrador")
    private Token token; 
    

    public Administrador() {
    }

    public Administrador( String usuario, String contrasena,Token token) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.token=token;
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
  
    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
    
}
