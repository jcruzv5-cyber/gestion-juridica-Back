package co.vinni.pagos.aplicacion;

import co.vinni.casos.aplicacion.CasoServicio;
import co.vinni.pagos.dominio.modelo.Pago;
import co.vinni.pagos.dominio.repositorio.PagoRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
public class PagoServicio {

    @Inject
    PagoRepositorio pagoRepositorio;

    @Inject
    CasoServicio casoServicio;

    public Pago registrar(Pago pago) {
        Pago resultado = pagoRepositorio.registrar(pago);
        recalcularSaldo(pago.casoId);
        return resultado;
    }

    public List<Pago> listarPorCaso(Long casoId) {
        return pagoRepositorio.obtenerPorCaso(casoId);
    }

    public Pago actualizar(Long id, Pago pago) {
        Pago resultado = pagoRepositorio.actualizar(id, pago);
        recalcularSaldo(pago.casoId);
        return resultado;
    }

    public void eliminar(Long id) {
        Long casoId = pagoRepositorio.eliminar(id);
        recalcularSaldo(casoId);
    }

    private void recalcularSaldo(Long casoId) {
        BigDecimal sumaPagos = pagoRepositorio.sumarPagosPorCaso(casoId);
        casoServicio.actualizarSaldoPendiente(casoId, sumaPagos);
    }
}
