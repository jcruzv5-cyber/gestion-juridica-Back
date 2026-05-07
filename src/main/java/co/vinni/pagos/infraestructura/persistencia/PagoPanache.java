package co.vinni.pagos.infraestructura.persistencia;

import co.vinni.pagos.dominio.modelo.Pago;
import co.vinni.pagos.dominio.repositorio.PagoRepositorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@ApplicationScoped
public class PagoPanache implements PagoRepositorio, PanacheRepository<PagoEntity> {

    @Override
    @Transactional
    public Pago registrar(Pago pago) {
        PagoEntity entity = PagoEntity.builder()
                .valor(pago.valor)
                .fecha(pago.fecha)
                .metodoPago(pago.metodoPago)
                .observaciones(pago.observaciones)
                .comprobante(pago.comprobante)
                .casoId(pago.casoId)
                .fechaCreacion(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();
        persist(entity);
        return toDomain(entity);
    }

    @Override
    public List<Pago> obtenerPorCaso(Long casoId) {
        return find("casoId", casoId).stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public Pago actualizar(Long id, Pago pago) {
        PagoEntity entity = findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Pago no encontrado con id: " + id));
        entity.valor = pago.valor;
        entity.fecha = pago.fecha;
        entity.metodoPago = pago.metodoPago;
        entity.observaciones = pago.observaciones;
        entity.comprobante = pago.comprobante;
        return toDomain(entity);
    }

    @Override
    @Transactional
    public Long eliminar(Long id) {
        PagoEntity entity = findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Pago no encontrado con id: " + id));
        Long casoId = entity.casoId;
        delete(entity);
        return casoId;
    }

    @Override
    public BigDecimal sumarPagosPorCaso(Long casoId) {
        return find("casoId", casoId).stream()
                .map(e -> e.valor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Pago toDomain(PagoEntity e) {
        return Pago.builder()
                .id(e.id)
                .valor(e.valor)
                .fecha(e.fecha)
                .metodoPago(e.metodoPago)
                .observaciones(e.observaciones)
                .comprobante(e.comprobante)
                .casoId(e.casoId)
                .fechaCreacion(e.fechaCreacion)
                .build();
    }
}
