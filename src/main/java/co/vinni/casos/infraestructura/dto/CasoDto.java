package co.vinni.casos.infraestructura.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

public record CasoDto(
        Long id,

        @NotBlank(message = "El título del caso es requerido")
        String titulo,

        String descripcion,

        @NotBlank(message = "El estado del caso es requerido")
        String estado,

        @NotBlank(message = "La prioridad del caso es requerida")
        String prioridad,

        String fechaCreacion,

        @DecimalMin(value = "0", inclusive = true, message = "El valor total debe ser mayor o igual a 0")
        BigDecimal valorTotal,

        BigDecimal saldoPendiente
) {
}
