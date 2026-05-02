package co.vinni.docentes.infraestructura;

import co.vinni.docentes.aplicacion.ClienteServicio;
import co.vinni.docentes.dominio.modelo.Cliente;
import co.vinni.docentes.infraestructura.dto.ClienteDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.List;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteRecursos {

    @Inject
    ClienteServicio clienteServicio;

    @POST
    @Operation(
            summary = "Crear un nuevo cliente",
            description = "Registra un cliente con su información personal, de contacto y legal"
    )
    @APIResponse(
            responseCode = "201",
            description = "Cliente creado"
    )
    @APIResponse(
            responseCode = "400",
            description = "Datos de entrada inválidos"
    )
    public Response crear(@Valid ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder()
                .tipoDocumento(clienteDto.tipoDocumento())
                .numeroDocumento(clienteDto.numeroDocumento())
                .nombres(clienteDto.nombres())
                .apellidos(clienteDto.apellidos())
                .fechaNacimiento(clienteDto.fechaNacimiento())
                .genero(clienteDto.genero())
                .estadoCivil(clienteDto.estadoCivil())
                .direccionResidencia(clienteDto.direccionResidencia())
                .ciudadMunicipio(clienteDto.ciudadMunicipio())
                .barrio(clienteDto.barrio())
                .telefonoPrincipal(clienteDto.telefonoPrincipal())
                .telefonoSecundario(clienteDto.telefonoSecundario())
                .correoElectronico(clienteDto.correoElectronico())
                .estratoSocioeconomico(clienteDto.estratoSocioeconomico())
                .ingresosMensuales(clienteDto.ingresosMensuales())
                .ocupacion(clienteDto.ocupacion())
                .indicadorPoblacionVulnerable(clienteDto.indicadorPoblacionVulnerable())
                .tipoPoblacionVulnerable(clienteDto.tipoPoblacionVulnerable())
                .aceptaHabeasData(clienteDto.aceptaHabeasData())
                .estadoUsuario(clienteDto.estadoUsuario())
                .build();

        clienteServicio.crear(cliente);
        return Response.status(Response.Status.CREATED).build();
    }





}