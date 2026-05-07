package co.vinni.pagos.infraestructura.persistencia;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "PAGOS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagoEntity extends PanacheEntity {

    @Column(name = "valor", nullable = false, precision = 15, scale = 2)
    public BigDecimal valor;

    @Column(name = "fecha", nullable = false, length = 30)
    public String fecha;

    @Column(name = "metodo_pago", nullable = false, length = 50)
    public String metodoPago;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    public String observaciones;

    @Column(name = "comprobante", columnDefinition = "TEXT")
    public String comprobante;

    @Column(name = "caso_id", nullable = false)
    public Long casoId;

    @Column(name = "fecha_creacion", length = 30)
    public String fechaCreacion;
}
