package co.vinni.docentes.infraestructura.persistencia;

import co.vinni.docentes.dominio.modelo.Cliente;
import co.vinni.docentes.dominio.modelo.ClienteEntity;
import co.vinni.docentes.dominio.repositorio.ClienteRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

@ApplicationScoped
public class ClientePersistencia implements ClienteRepositorio {

    @Override
    @Transactional
    public void crear(Cliente cliente) {
        ClienteEntity entity = ClienteEntity.builder()
                .tipoDocumento(cliente.tipoDocumento)
                .numeroDocumento(cliente.numeroDocumento)
                .nombres(cliente.nombres)
                .apellidos(cliente.apellidos)
                .fechaNacimiento(cliente.fechaNacimiento)
                .genero(cliente.genero)
                .estadoCivil(cliente.estadoCivil)
                .direccionResidencia(cliente.direccionResidencia)
                .ciudadMunicipio(cliente.ciudadMunicipio)
                .barrio(cliente.barrio)
                .telefonoPrincipal(cliente.telefonoPrincipal)
                .telefonoSecundario(cliente.telefonoSecundario)
                .correoElectronico(cliente.correoElectronico)
                .estratoSocioeconomico(cliente.estratoSocioeconomico)
                .ingresosMensuales(cliente.ingresosMensuales)
                .ocupacion(cliente.ocupacion)
                .indicadorPoblacionVulnerable(cliente.indicadorPoblacionVulnerable)
                .tipoPoblacionVulnerable(cliente.tipoPoblacionVulnerable)
                .aceptaHabeasData(cliente.aceptaHabeasData)
                .estadoUsuario(
                        cliente.estadoUsuario == null || cliente.estadoUsuario.isBlank()
                                ? "Activo"
                                : cliente.estadoUsuario
                )
                .fechaRegistro(LocalDateTime.now())
                .build();

        entity.persist();
    }
}