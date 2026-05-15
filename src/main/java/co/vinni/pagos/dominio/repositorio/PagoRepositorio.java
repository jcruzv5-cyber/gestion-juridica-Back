package co.vinni.pagos.dominio.repositorio;

import co.vinni.pagos.dominio.modelo.Pago;
import java.math.BigDecimal;
import java.util.List;

public interface PagoRepositorio {
    Pago registrar(Pago pago);
    List<Pago> obtenerPorCaso(Long casoId);
    Pago actualizar(Long id, Pago pago);
    Long eliminar(Long id);
    BigDecimal sumarPagosPorCaso(Long casoId);
}
