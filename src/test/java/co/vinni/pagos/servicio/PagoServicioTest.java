package co.vinni.pagos.servicio;

import co.vinni.casos.aplicacion.CasoServicio;
import co.vinni.pagos.aplicacion.PagoServicio;
import co.vinni.pagos.dominio.modelo.Pago;
import co.vinni.pagos.dominio.repositorio.PagoRepositorio;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@QuarkusTest
public class PagoServicioTest {

    @Inject
    PagoServicio pagoServicio;

    @InjectMock
    PagoRepositorio pagoRepositorio;

    @InjectMock
    CasoServicio casoServicio;

    private Pago pagoPrueba;

    @BeforeEach
    public void setup() {
        pagoPrueba = Pago.builder()
                .id(1L)
                .valor(new BigDecimal("150000"))
                .fecha("2026-05-26")
                .metodoPago("E")
                .observaciones("Pago inicial")
                .comprobante("COMP-001")
                .casoId(10L)
                .fechaCreacion("2026-05-26")
                .build();
    }

    @Test
    public void testRegistrarPago_debeRegistrarYRecalcularSaldo() {
        when(pagoRepositorio.registrar(any(Pago.class))).thenReturn(pagoPrueba);
        when(pagoRepositorio.sumarPagosPorCaso(10L)).thenReturn(new BigDecimal("150000"));

        Pago resultado = pagoServicio.registrar(pagoPrueba);

        assertEquals(pagoPrueba, resultado);
        verify(pagoRepositorio, times(1)).registrar(any(Pago.class));
        verify(pagoRepositorio, times(1)).sumarPagosPorCaso(10L);
        verify(casoServicio, times(1)).actualizarSaldoPendiente(10L, new BigDecimal("150000"));
    }

    @Test
    public void testListarPorCaso_debeRetornarPagosDelRepositorio() {
        List<Pago> listaMock = List.of(pagoPrueba);

        when(pagoRepositorio.obtenerPorCaso(10L)).thenReturn(listaMock);

        List<Pago> resultado = pagoServicio.listarPorCaso(10L);

        assertEquals(1, resultado.size());
        assertEquals(new BigDecimal("150000"), resultado.get(0).valor);
        verify(pagoRepositorio, times(1)).obtenerPorCaso(10L);
    }

    @Test
    public void testActualizarPago_debeActualizarYRecalcularSaldo() {
        when(pagoRepositorio.actualizar(eq(1L), any(Pago.class))).thenReturn(pagoPrueba);
        when(pagoRepositorio.sumarPagosPorCaso(10L)).thenReturn(new BigDecimal("200000"));

        Pago resultado = pagoServicio.actualizar(1L, pagoPrueba);

        assertEquals(pagoPrueba, resultado);
        verify(pagoRepositorio, times(1)).actualizar(eq(1L), any(Pago.class));
        verify(pagoRepositorio, times(1)).sumarPagosPorCaso(10L);
        verify(casoServicio, times(1)).actualizarSaldoPendiente(10L, new BigDecimal("200000"));
    }

    @Test
    public void testEliminarPago_debeEliminarYRecalcularSaldo() {
        when(pagoRepositorio.eliminar(1L)).thenReturn(10L);
        when(pagoRepositorio.sumarPagosPorCaso(10L)).thenReturn(new BigDecimal("50000"));

        pagoServicio.eliminar(1L);

        verify(pagoRepositorio, times(1)).eliminar(1L);
        verify(pagoRepositorio, times(1)).sumarPagosPorCaso(10L);
        verify(casoServicio, times(1)).actualizarSaldoPendiente(10L, new BigDecimal("50000"));
    }
}
