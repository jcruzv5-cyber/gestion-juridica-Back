package co.vinni.casos.infraestructura.persistencia;

import co.vinni.casos.dominio.modelo.Caso;
import co.vinni.casos.dominio.modelo.CasoEntity;
import co.vinni.casos.dominio.repositorio.CasoRepositorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CasoPanache implements CasoRepositorio, PanacheRepository<CasoEntity> {

    @Override
    @Transactional
    public void crear(Caso caso) {
        CasoEntity entity = CasoEntity
                .builder()
                .titulo(caso.titulo)
                .descripcion(caso.descripcion)
                .estado(caso.estado)
                .prioridad(caso.prioridad)
                .fechaCreacion(caso.fechaCreacion)
                .valorTotal(caso.valorTotal)
                .saldoPendiente(caso.valorTotal)
                .build();
        persist(entity);
    }

    @Override
    public List<Caso> obtenerTodos() {
        return listAll().stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Optional<Caso> buscarPorId(Long id) {
        return findByIdOptional(id).map(this::toDomain);
    }

    @Override
    @Transactional
    public void actualizarSaldoPendiente(Long casoId, BigDecimal saldoPendiente) {
        findByIdOptional(casoId).ifPresentOrElse(
                entity -> entity.saldoPendiente = saldoPendiente,
                () -> { throw new NotFoundException("Caso no encontrado con id: " + casoId); }
        );
    }

    private Caso toDomain(CasoEntity e) {
        return Caso.builder()
                .id(e.id)
                .titulo(e.titulo)
                .descripcion(e.descripcion)
                .estado(e.estado)
                .prioridad(e.prioridad)
                .fechaCreacion(e.fechaCreacion)
                .valorTotal(e.valorTotal)
                .saldoPendiente(e.saldoPendiente)
                .build();
    }
}
