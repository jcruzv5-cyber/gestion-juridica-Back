package co.vinni.docentes.dominio.modelo;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public class Cliente {
    public String tipoDocumento;
    public String numeroDocumento;
    public String nombres;
    public String apellidos;
    public LocalDate fechaNacimiento;
    public String genero;
    public String estadoCivil;
    public String direccionResidencia;
    public String ciudadMunicipio;
    public String barrio;
    public String telefonoPrincipal;
    public String telefonoSecundario;
    public String correoElectronico;
    public String estratoSocioeconomico;
    public String ingresosMensuales;
    public String ocupacion;
    public Boolean indicadorPoblacionVulnerable;
    public String tipoPoblacionVulnerable;
    public Boolean aceptaHabeasData;
    public String estadoUsuario;
    public LocalDateTime fechaRegistro;
}
