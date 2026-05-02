package co.vinni.docentes.infraestructura.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClienteDto(

        @NotBlank(message = "El tipo de documento es requerido")
        String tipoDocumento,

        @NotBlank(message = "El número de documento es requerido")
        String numeroDocumento,

        @NotBlank(message = "Los nombres son requeridos")
        String nombres,

        @NotBlank(message = "Los apellidos son requeridos")
        String apellidos,

        @NotNull(message = "La fecha de nacimiento es requerida")
        LocalDate fechaNacimiento,

        @NotBlank(message = "El género es requerido")
        String genero,

        @NotBlank(message = "El estado civil es requerido")
        String estadoCivil,

        @NotBlank(message = "La dirección de residencia es requerida")
        String direccionResidencia,

        @NotBlank(message = "La ciudad o municipio es requerido")
        String ciudadMunicipio,

        String barrio,

        @NotBlank(message = "El teléfono principal es requerido")
        String telefonoPrincipal,

        String telefonoSecundario,

        @Email(message = "El formato del correo es incorrecto")
        @NotBlank(message = "El correo electrónico es requerido")
        String correoElectronico,

        @NotBlank(message = "El estrato socioeconómico es requerido")
        String estratoSocioeconomico,

        @NotBlank(message = "Los ingresos mensuales son requeridos")
        String ingresosMensuales,

        @NotBlank(message = "La ocupación es requerida")
        String ocupacion,

        @NotNull(message = "El indicador de población vulnerable es requerido")
        Boolean indicadorPoblacionVulnerable,

        String tipoPoblacionVulnerable,

        @NotNull(message = "La aceptación de Habeas Data es requerida")
        Boolean aceptaHabeasData,

        @NotBlank(message = "El estado del usuario es requerido")
        String estadoUsuario

) {
}
