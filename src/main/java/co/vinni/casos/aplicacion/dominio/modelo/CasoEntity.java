package co.vinni.casos.aplicacion.dominio.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "CASOS",
    uniqueConstraints = @UniqueConstraint(name = "uk_numero_radicado", columnNames = "numero_radicado")
)
public class CasoEntity extends PanacheEntity {

    @Column(name = "numero_radicado", nullable = false, unique = true, length = 30)
    public String numeroRadicado;

    @Column(name = "fecha_inicio", nullable = false)
    public LocalDate fechaInicio;

    @Column(name = "tipo_caso", nullable = false, length = 50)
    public String tipoCaso;

    @Column(name = "estado", length = 20)
    public String estado;

    @Column(name = "prioridad", length = 20)
    public String prioridad;

    @Column(name = "descripcion", length = 500)
    public String descripcion;

    @Column(name = "cliente_nombre", nullable = false, length = 150)
    public String clienteNombre;

    @Column(name = "cliente_documento", length = 30)
    public String clienteDocumento;

    @Column(name = "cliente_telefono", length = 20)
    public String clienteTelefono;

    @Column(name = "cliente_correo", length = 100)
    public String clienteCorreo;

    @Column(name = "parte_demandada", nullable = false, length = 150)
    public String parteDemandada;

    @Column(name = "responsable", nullable = false, length = 50)
    public String responsable;

    @Column(name = "responsable_nombre", length = 150)
    public String responsableNombre;

    @Column(name = "especialidad", length = 100)
    public String especialidad;

    @Column(name = "observaciones", length = 300)
    public String observaciones;

    @Column(name = "fecha_creacion")
    public LocalDateTime fechaCreacion;

    @Column(name = "usuario_creacion", length = 100)
    public String usuarioCreacion;
}
