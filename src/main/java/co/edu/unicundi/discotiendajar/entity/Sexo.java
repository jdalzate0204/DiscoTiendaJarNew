package co.edu.unicundi.discotiendajar.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author acer
 */
@Entity
@Table (name = "sexo", schema = "adicional")

@NamedQueries({
    @NamedQuery(name = "Sexo.Listar", query = "SELECT NEW co.edu.unicundi.discotiendajar.dto.Adicional(s.id, s.descripcion) FROM Sexo s")
})
public class Sexo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "descripcion", nullable = false, length = 9)
    private String descripcion;
    
    @OneToOne(mappedBy = "sexo")
    private Artista artista;

    public Sexo() {
    }

    public Sexo(String descripcion, Artista artista) {
        this.descripcion = descripcion;
        this.artista = artista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
