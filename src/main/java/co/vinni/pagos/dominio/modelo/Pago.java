package co.vinni.pagos.dominio.modelo;

import lombok.Builder;
import java.math.BigDecimal;

@Builder
public class Pago {
    public Long id;
    public BigDecimal valor;
    public String fecha;
    public String metodoPago;
    public String observaciones;
    public String comprobante;
    public Long casoId;
    public String fechaCreacion;
}
