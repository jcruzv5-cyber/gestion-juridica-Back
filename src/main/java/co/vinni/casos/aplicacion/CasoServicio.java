package co.vinni.casos.aplicacion;

import co.vinni.casos.dominio.modelo.Caso;
import co.vinni.casos.dominio.repositorio.CasoRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.math.BigDecimal;
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

    public void actualizarSaldoPendiente(Long casoId, BigDecimal sumaPagos) {
        repositorio.buscarPorId(casoId).ifPresent(caso -> {
            BigDecimal valorTotal = caso.valorTotal != null ? caso.valorTotal : BigDecimal.ZERO;
            BigDecimal saldo = valorTotal.subtract(sumaPagos);
            repositorio.actualizarSaldoPendiente(casoId, saldo);
        });
    }
}
