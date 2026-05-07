package co.vinni.casos.dominio.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "CASOS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CasoEntity extends PanacheEntity {

    @Column(name = "titulo", nullable = false, length = 200)
    public String titulo;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    public String descripcion;

    @Column(name = "estado", nullable = false, length = 50)
    public String estado;

    @Column(name = "prioridad", nullable = false, length = 20)
    public String prioridad;

    @Column(name = "fecha_creacion", length = 30)
    public String fechaCreacion;

    @Column(name = "valor_total", precision = 15, scale = 2)
    public BigDecimal valorTotal;

    @Column(name = "saldo_pendiente", precision = 15, scale = 2)
    public BigDecimal saldoPendiente;
}
