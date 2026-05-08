package co.vinni.abogados.infraestructura.persistencia;

import co.vinni.abogados.dominio.modelo.AbogadoEntity;
import co.vinni.abogados.repositorio.AbogadoRepositorio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AbogadoPanache implements PanacheRepository<AbogadoEntity>, AbogadoRepositorio {

    @Override
    public AbogadoEntity guardar(AbogadoEntity abogado) {
        persist(abogado);
        return abogado;
    }
}