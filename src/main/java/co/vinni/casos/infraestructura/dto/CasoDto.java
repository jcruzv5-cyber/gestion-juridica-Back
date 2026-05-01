package co.vinni.casos.infraestructura.dto;

import jakarta.validation.constraints.NotBlank;

public record CasoDto(
        Long id,

        @NotBlank(message = "El título del caso es requerido")
        String titulo,

        String descripcion,

        @NotBlank(message = "El estado del caso es requerido")
        String estado,

        @NotBlank(message = "La prioridad del caso es requerida")
        String prioridad,

        String fechaCreacion
) {
}
