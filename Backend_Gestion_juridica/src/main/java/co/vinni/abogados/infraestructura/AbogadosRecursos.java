package co.vinni.abogados.infraestructura;

import co.vinni.abogados.aplicacion.AbogadoServicio;
import co.vinni.abogados.infraestructura.dto.AbogadoDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/abogados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AbogadosRecursos {

    @Inject
    AbogadoServicio abogadoServicio;

    @POST
    public Response registrar(@Valid AbogadoDto dto) {
        return Response.status(Response.Status.CREATED)
                .entity(abogadoServicio.registrar(dto))
                .build();
    }
}