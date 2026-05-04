package co.vinni.casos;

import co.vinni.casos.aplicacion.CasoServicio;
import co.vinni.casos.dominio.modelo.Caso;
import co.vinni.casos.infraestructura.dto.CasoDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Map;

@Path("/casos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CasoResource {

    @Inject
    CasoServicio casoServicio;

    @POST
    public Response registrarCaso(@Valid CasoDto dto) {
        Caso caso = new Caso();
        caso.setNumeroRadicado(dto.getNumeroRadicado());
        caso.setFechaInicio(dto.getFechaInicio());
        caso.setTipoCaso(dto.getTipoCaso());
        caso.setDescripcion(dto.getDescripcion());
        caso.setCliente(dto.getCliente());
        caso.setParteDemandada(dto.getParteDemandada());
        caso.setResponsable(dto.getResponsable());
        caso.setUsuarioCreacion(dto.getUsuarioCreacion());

        Caso resultado = casoServicio.registrarCaso(caso);

        return Response.status(Response.Status.CREATED)
                .entity(Map.of(
                    "success", true,
                    "mensaje", "Caso registrado exitosamente",
                    "data", resultado
                ))
                .build();
    }
}