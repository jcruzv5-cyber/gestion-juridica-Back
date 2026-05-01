package co.vinni.casos.aplicacion;

import co.vinni.casos.dominio.modelo.Caso;
import co.vinni.casos.dominio.repositorio.CasoRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CasoServicio {

    @Inject
    CasoRepositorio repositorio;

    public void crear(Caso caso) {
        repositorio.crear(caso);
    }

    public List<Caso> listar() {
        return repositorio.obtenerTodos();
    }
}
