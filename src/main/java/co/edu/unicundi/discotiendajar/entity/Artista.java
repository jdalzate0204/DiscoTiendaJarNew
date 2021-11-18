package co.edu.unicundi.discotiendajar.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author acer
 */
@Entity
@Table (name = "artista", schema = "principal")

@NamedQueries({
    @NamedQuery(name = "Artista.ContarNombre", query = "SELECT COUNT(a.nombre) FROM Artista a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Artista.ListarSelect", query = "SELECT NEW co.edu.unicundi.discotiendajar.dto.ArtistaDto(a.id, a.nombre) FROM Artista a"),
    @NamedQuery(name = "Artista.ListarTodos", query = "SELECT  NEW co.edu.unicundi.discotiendajar.dto.ArtistaDto(a.id , a.nombre, a.fechaNacimiento, a.nacionalidad, a.sexo.descripcion,a.generoMusical.descripcion)\n" 
            +"FROM Artista a")
})
public class Artista implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    
    @Column(name = "fecha_nacimiento", nullable = false)
    private String fechaNacimiento;

    @Column(name = "nacionalidad", nullable = false, length = 20)
    private String nacionalidad;
    
    @OneToOne
    @JoinColumn(name = "id_sexo", nullable = false)
    private Sexo sexo;
    
    @OneToOne
    @JoinColumn(name = "id_genero_musical", nullable = false)
    private GeneroMusical generoMusical;
    
    @OneToMany(mappedBy = "artista", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Album> album;
    
    @Transient //NoMapped
    private Integer idSexo;
    
    @Transient
    private Integer idGeneroMusical;
    
 

    public Artista() {
    }

    public Artista(String nombre, String fechaNacimiento, String nacionalidad, Sexo sexo, GeneroMusical generoMusical, List<Album> album) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.generoMusical = generoMusical;
        this.album = album;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    //@XmlTransient
    @JsonIgnore
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    //@XmlTransient
    @JsonIgnore
    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(GeneroMusical generoMusical) {
        this.generoMusical = generoMusical;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public Integer getIdGeneroMusical() {
        return idGeneroMusical;
    }

    public void setIdGeneroMusical(Integer idGeneroMusical) {
        this.idGeneroMusical = idGeneroMusical;
    }
}
