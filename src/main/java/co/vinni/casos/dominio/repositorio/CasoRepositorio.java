package co.vinni.casos.dominio.repositorio;

import co.vinni.casos.dominio.modelo.Caso;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CasoRepositorio {
    void crear(Caso caso);
    List<Caso> obtenerTodos();
    Optional<Caso> buscarPorId(Long id);
    void actualizarSaldoPendiente(Long casoId, BigDecimal saldoPendiente);
}
