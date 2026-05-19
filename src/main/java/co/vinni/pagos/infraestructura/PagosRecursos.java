package co.vinni.pagos.infraestructura;

import co.vinni.pagos.aplicacion.PagoServicio;
import co.vinni.pagos.dominio.modelo.Pago;
import co.vinni.pagos.infraestructura.dto.PagoDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import java.util.List;

@Path("/pagos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagosRecursos {

    @Inject
    PagoServicio pagoServicio;

    @POST
    @Operation(
            summary = "Registrar un pago",
            description = "Registra un pago asociado a un caso y actualiza el saldo pendiente"
    )
    @APIResponse(responseCode = "201", description = "Pago registrado exitosamente")
    @APIResponse(responseCode = "400", description = "Datos de entrada inválidos")
    public Response registrar(@Valid PagoDto dto) {
        Pago pago = Pago.builder()
                .valor(dto.valor())
                .fecha(dto.fecha())
                .metodoPago(dto.metodoPago())
                .observaciones(dto.observaciones())
                .comprobante(dto.comprobante())
                .casoId(dto.casoId())
                .build();
        Pago resultado = pagoServicio.registrar(pago);
        return Response.status(Response.Status.CREATED)
                .entity(toDto(resultado))
                .build();
    }

    @GET
    @Path("/caso/{casoId}")
    @Operation(
            summary = "Historial de pagos por caso",
            description = "Retorna todos los pagos registrados para un caso específico"
    )
    @APIResponse(responseCode = "200", description = "Historial obtenido exitosamente")
    public Response obtenerPorCaso(@PathParam("casoId") Long casoId) {
        List<PagoDto> dtos = pagoServicio.listarPorCaso(casoId).stream()
                .map(this::toDto)
                .toList();
        return Response.ok(dtos).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(
            summary = "Editar un pago",
            description = "Actualiza los datos de un pago y recalcula el saldo pendiente del caso"
    )
    @APIResponse(responseCode = "200", description = "Pago actualizado exitosamente")
    @APIResponse(responseCode = "404", description = "Pago no encontrado")
    public Response actualizar(@PathParam("id") Long id, @Valid PagoDto dto) {
        Pago pago = Pago.builder()
                .valor(dto.valor())
                .fecha(dto.fecha())
                .metodoPago(dto.metodoPago())
                .observaciones(dto.observaciones())
                .comprobante(dto.comprobante())
                .casoId(dto.casoId())
                .build();
        Pago resultado = pagoServicio.actualizar(id, pago);
        return Response.ok(toDto(resultado)).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(
            summary = "Eliminar un pago",
            description = "Elimina un pago y actualiza el saldo pendiente del caso"
    )
    @APIResponse(responseCode = "204", description = "Pago eliminado exitosamente")
    @APIResponse(responseCode = "404", description = "Pago no encontrado")
    public Response eliminar(@PathParam("id") Long id) {
        pagoServicio.eliminar(id);
        return Response.noContent().build();
    }

    private PagoDto toDto(Pago p) {
        return new PagoDto(
                p.id,
                p.valor,
                p.fecha,
                p.metodoPago,
                p.observaciones,
                p.comprobante,
                p.casoId,
                p.fechaCreacion
        );
    }
}
