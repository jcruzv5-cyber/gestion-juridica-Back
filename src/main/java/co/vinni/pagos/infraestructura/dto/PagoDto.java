package co.vinni.pagos.infraestructura.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record PagoDto(
        Long id,

        @NotNull(message = "El valor del pago es requerido")
        @DecimalMin(value = "0.01", message = "El valor debe ser mayor a 0")
        BigDecimal valor,

        @NotBlank(message = "La fecha del pago es requerida")
        String fecha,

        @NotBlank(message = "El método de pago es requerido")
        String metodoPago,

        String observaciones,

        String comprobante,

        @NotNull(message = "El caso asociado es requerido")
        Long casoId,

        String fechaCreacion
) {
}
