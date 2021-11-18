package co.edu.unicundi.discotiendajar.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author acer
 */
@Entity
@Table (name = "genero_musical", schema = "adicional")

@NamedQueries({
    @NamedQuery(name = "GeneroMusical.Listar", query = "SELECT NEW co.edu.unicundi.discotiendajar.dto.Adicional(g.id, g.descripcion) "
                                                        + "FROM GeneroMusical g")
})
public class GeneroMusical implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "descripcion", nullable = false, length = 30)
    private String descripcion;
    
    @OneToOne(mappedBy = "generoMusical")
    private Artista artista;

    public GeneroMusical() {
    }

    public GeneroMusical(String descripcion, Artista artista) {
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
