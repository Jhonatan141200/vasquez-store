package vasquez.store.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {
    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private String celular;
    private String direccion;
    @Column(name = "correo_electronico")
    private String correo;
    @OneToMany(mappedBy = "cliente")
    List<Compra> compras;
}
