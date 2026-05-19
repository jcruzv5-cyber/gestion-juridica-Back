package co.vinni.casos.aplicacion;

import co.vinni.casos.aplicacion.dominio.infraestructura.dto.CasoDto;
import co.vinni.casos.aplicacion.dominio.modelo.Caso;
import co.vinni.common.RadicadoDuplicadoException;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.LinkedHashMap;
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
        caso.setEstado(dto.getEstado() != null ? dto.getEstado() : "activo");
        caso.setPrioridad(dto.getPrioridad() != null ? dto.getPrioridad() : "media");
        caso.setDescripcion(dto.getDescripcion());
        caso.setClienteNombre(dto.getClienteNombre());
        caso.setClienteDocumento(dto.getClienteDocumento());
        caso.setClienteTelefono(dto.getClienteTelefono());
        caso.setClienteCorreo(dto.getClienteCorreo());
        caso.setParteDemandada(dto.getParteDemandada());
        caso.setResponsable(dto.getResponsable());
        caso.setResponsableNombre(dto.getResponsableNombre());
        caso.setEspecialidad(dto.getEspecialidad());
        caso.setObservaciones(dto.getObservaciones());
        caso.setUsuarioCreacion(dto.getUsuarioCreacion() != null ? dto.getUsuarioCreacion() : "sistema");

        try {
            Caso resultado = casoServicio.registrarCaso(caso);
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("success", true);
            body.put("mensaje", "Caso registrado exitosamente");
            body.put("data", resultado);
            return Response.status(Response.Status.CREATED).entity(body).build();
        } catch (RadicadoDuplicadoException ex) {
            Map<String, Object> error = new LinkedHashMap<>();
            error.put("success", false);
            error.put("codigo", "RADICADO_DUPLICADO");
            error.put("mensaje", ex.getMessage());
            return Response.status(Response.Status.CONFLICT).entity(error).build();
        }
    }
}