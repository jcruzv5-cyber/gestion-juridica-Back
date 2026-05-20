package co.vinni.casos.aplicacion;

import java.util.List;
import co.vinni.casos.dominio.modelo.Caso;
import co.vinni.casos.dominio.repositorio.CasoRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CasoServicio {

    @Inject
    CasoRepositorio casoRepositorio;

    public Caso registrarCaso(Caso caso) {
        return casoRepositorio.registrar(caso);
    }

    public List<Caso> listarCasos() {
        return casoRepositorio.listarTodos();
    }
}