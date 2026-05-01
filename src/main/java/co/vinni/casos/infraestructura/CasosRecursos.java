package co.vinni.casos.infraestructura;

import co.vinni.casos.aplicacion.CasoServicio;
import co.vinni.casos.dominio.modelo.Caso;
import co.vinni.casos.infraestructura.dto.CasoDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Path("/casos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CasosRecursos {

    @Inject
    CasoServicio casoServicio;

    @POST
    @Operation(
        summary = "Crear un nuevo caso",
        description = "Registra un caso con título, descripción, estado y prioridad"
    )
    @APIResponse(responseCode = "201", description = "Caso creado exitosamente")
    @APIResponse(responseCode = "400", description = "Datos de entrada inválidos")
    public Response crear(@Valid CasoDto casoDto) {
        Caso caso = Caso.builder()
                .titulo(casoDto.titulo())
                .descripcion(casoDto.descripcion())
                .estado(casoDto.estado())
                .prioridad(casoDto.prioridad())
                .fechaCreacion(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();
        casoServicio.crear(caso);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Operation(
        summary = "Listar todos los casos",
        description = "Retorna la lista completa de casos registrados en el sistema"
    )
    @APIResponse(responseCode = "200", description = "Lista de casos obtenida exitosamente")
    public Response obtenerTodos() {
        List<CasoDto> casoDtos = casoServicio.listar().stream()
                .map(caso -> new CasoDto(
                        caso.id,
                        caso.titulo,
                        caso.descripcion,
                        caso.estado,
                        caso.prioridad,
                        caso.fechaCreacion))
                .toList();
        return Response.status(Response.Status.OK).entity(casoDtos).build();
    }
}
