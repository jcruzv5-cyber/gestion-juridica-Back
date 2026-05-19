package co.vinni.casos.dominio.modelo;

import lombok.Builder;
import java.math.BigDecimal;

@Builder
public class Caso {
    public Long id;
    public String titulo;
    public String descripcion;
    public String estado;
    public String prioridad;
    public String fechaCreacion;
    public BigDecimal valorTotal;
    public BigDecimal saldoPendiente;
}
