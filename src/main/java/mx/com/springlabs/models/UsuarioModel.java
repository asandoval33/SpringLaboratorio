package mx.com.springlabs.models;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;//genera getters y setters

@Data
@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String email;
    private String username;
    private String password;
    private Integer prioridad;
}
