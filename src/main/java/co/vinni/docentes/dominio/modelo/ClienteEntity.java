package co.vinni.docentes.dominio.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "CLIENTES")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity extends PanacheEntity {

    @Column(nullable = false)
    public String tipoDocumento;

    @Column(nullable = false, unique = true)
    public String numeroDocumento;

    @Column(nullable = false)
    public String nombres;

    @Column(nullable = false)
    public String apellidos;

    public LocalDate fechaNacimiento;

    public String genero;

    public String estadoCivil;

    public String direccionResidencia;

    public String ciudadMunicipio;

    public String barrio;

    @Column(nullable = false)
    public String telefonoPrincipal;

    public String telefonoSecundario;

    @Column(nullable = false)
    public String correoElectronico;

    public String estratoSocioeconomico;

    public String ingresosMensuales;

    public String ocupacion;

    public Boolean indicadorPoblacionVulnerable;

    public String tipoPoblacionVulnerable;

    @Column(nullable = false)
    public Boolean aceptaHabeasData;

    public String estadoUsuario;

    public LocalDateTime fechaRegistro;
}
