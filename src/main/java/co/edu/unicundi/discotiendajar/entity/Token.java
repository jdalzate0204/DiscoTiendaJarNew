/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendajar.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ALEJANDRA
 */
@Entity
@Table (name = "token", schema = "principal")
@NamedQueries({
    @NamedQuery(name = "Token.BuscarToken", query = "SELECT COUNT(t.administrador) FROM Token t WHERE t.administrador.id = :idAdmin"),
    @NamedQuery(name="Token.Eliminar",query="DELETE FROM Token t WHERE t.administrador.id = :idAdmin"),
    @NamedQuery(name = "Token.ValidarToken", query = "SELECT COUNT(t.token) FROM Token t WHERE t.token = :token")
})
public class Token implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    @Column(name = "token", nullable = false, length = 100)
    private String token;
    
    @OneToOne
    @JoinColumn(name = "id_administrador", nullable = false)
    private Administrador administrador;

    public Token() {
    }

    public Token( String token, Administrador administrador) {
       
        this.token = token;
        this.administrador = administrador;
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
}
