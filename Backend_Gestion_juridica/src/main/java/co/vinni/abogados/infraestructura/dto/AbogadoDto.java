package co.vinni.abogados.infraestructura.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AbogadoDto {

    @NotBlank
    public String nombreCompleto;

    @NotBlank
    public String numeroCedula;

    @NotBlank
    public String tarjetaProfesional;

    @NotBlank
    public String especialidad;

    @Email
    @NotBlank
    public String correoElectronico;

    @NotBlank
    public String telefono;
}