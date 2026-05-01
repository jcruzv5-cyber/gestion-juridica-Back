package co.vinni.casos.infraestructura.persistencia;

import co.vinni.casos.dominio.modelo.Caso;
import co.vinni.casos.dominio.modelo.CasoEntity;
import co.vinni.casos.dominio.repositorio.CasoRepositorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

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
                .build();
        persist(entity);
    }

    @Override
    public List<Caso> obtenerTodos() {
        return listAll().stream().map(entidad ->
            Caso.builder()
                .id(entidad.id)
                .titulo(entidad.titulo)
                .descripcion(entidad.descripcion)
                .estado(entidad.estado)
                .prioridad(entidad.prioridad)
                .fechaCreacion(entidad.fechaCreacion)
                .build()
        ).toList();
    }
}
