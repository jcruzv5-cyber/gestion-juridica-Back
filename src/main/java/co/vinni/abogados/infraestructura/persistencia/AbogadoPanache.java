package co.vinni.abogados.infraestructura.persistencia;

import co.vinni.abogados.dominio.modelo.AbogadoEntity;
import co.vinni.abogados.repositorio.AbogadoRepositorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

// Implementación del repositorio usando Panache (ORM de Quarkus)
@ApplicationScoped
public class AbogadoPanache implements PanacheRepository<AbogadoEntity>, AbogadoRepositorio {

    @Transactional
    @Override
    public AbogadoEntity guardar(AbogadoEntity abogado) {
        persist(abogado); // guarda en la BD
        return abogado;
    }
}