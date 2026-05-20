package co.vinni.casos.infraestructura.persistencia;

import co.vinni.casos.dominio.modelo.Caso;
import co.vinni.casos.dominio.repositorio.CasoRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CasoRepositorioImpl implements CasoRepositorio {

    @Inject
    EntityManager em;

    @Override
    @Transactional
    public Caso registrar(Caso caso) {
        CasoEntity entity = toEntity(caso);
        em.persist(entity);
        return toDomain(entity);
    }

    @Override
    public List<Caso> listarTodos() {
            return em.createQuery("FROM CasoEntity", CasoEntity.class)
                    .getResultList()
                    .stream()
                    .map(this::toDomain)
                    .toList();
    }

    private CasoEntity toEntity(Caso caso) {
        CasoEntity e = new CasoEntity();
        e.setNumeroRadicado(caso.getNumeroRadicado());
        e.setFechaInicio(caso.getFechaInicio());
        e.setTipoCaso(caso.getTipoCaso());
        e.setDescripcion(caso.getDescripcion());
        e.setCliente(caso.getCliente());
        e.setParteDemandada(caso.getParteDemandada());
        e.setResponsable(caso.getResponsable());

        e.setEstado(caso.getEstado());
        e.setPrioridad(caso.getPrioridad());
        e.setAbogadoId(caso.getAbogadoId());

        e.setUsuarioCreacion(caso.getUsuarioCreacion());

        return e;
    }

    private Caso toDomain(CasoEntity e) {
        Caso c = new Caso();

        c.setId(e.getId());
        c.setNumeroRadicado(e.getNumeroRadicado());
        c.setFechaInicio(e.getFechaInicio());
        c.setTipoCaso(e.getTipoCaso());
        c.setDescripcion(e.getDescripcion());
        c.setCliente(e.getCliente());
        c.setParteDemandada(e.getParteDemandada());
        c.setResponsable(e.getResponsable());

        c.setEstado(e.getEstado());
        c.setPrioridad(e.getPrioridad());
        c.setAbogadoId(e.getAbogadoId());

        c.setFechaCreacion(e.getFechaCreacion());
        c.setUsuarioCreacion(e.getUsuarioCreacion());

        return c;
    }
}