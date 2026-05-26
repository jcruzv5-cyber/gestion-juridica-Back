package co.vinni.casos.servicio;

import co.vinni.casos.aplicacion.CasoServicio;
import co.vinni.casos.dominio.modelo.Caso;
import co.vinni.casos.dominio.repositorio.CasoRepositorio;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@QuarkusTest
public class CasoServicioTest {

    @Inject
    CasoServicio casoServicio;

    @InjectMock
    CasoRepositorio casoRepositorio;

    private Caso casoPrueba;

    @BeforeEach
    public void setup() {
        casoPrueba = Caso.builder()
                .id(1L)
                .titulo("Caso de prueba")
                .descripcion("Descripción de prueba")
                .estado("ABIERTO")
                .prioridad("ALTA")
                .fechaCreacion("2026-05-26")
                .valorTotal(new BigDecimal("1000000"))
                .saldoPendiente(new BigDecimal("1000000"))
                .build();
    }

    @Test
    public void testCrearCaso_debeInvocarRepositorioUnaVez() {
        casoServicio.crear(casoPrueba);

        verify(casoRepositorio, times(1)).crear(any(Caso.class));
    }

    @Test
    public void testCrearCaso_debeEnviarDatosCorrectosAlRepositorio() {
        casoServicio.crear(casoPrueba);

        ArgumentCaptor<Caso> captor = ArgumentCaptor.forClass(Caso.class);
        verify(casoRepositorio).crear(captor.capture());

        Caso casoCapturado = captor.getValue();

        assertEquals(1L, casoCapturado.id);
        assertEquals("Caso de prueba", casoCapturado.titulo);
        assertEquals("Descripción de prueba", casoCapturado.descripcion);
        assertEquals("ABIERTO", casoCapturado.estado);
        assertEquals("ALTA", casoCapturado.prioridad);
        assertEquals("2026-05-26", casoCapturado.fechaCreacion);
        assertEquals(new BigDecimal("1000000"), casoCapturado.valorTotal);
        assertEquals(new BigDecimal("1000000"), casoCapturado.saldoPendiente);
    }

    @Test
    public void testListarCasos_debeRetornarListaDelRepositorio() {
        List<Caso> listaMock = List.of(casoPrueba);

        when(casoRepositorio.obtenerTodos()).thenReturn(listaMock);

        List<Caso> resultado = casoServicio.listar();

        assertEquals(1, resultado.size());
        assertEquals("Caso de prueba", resultado.get(0).titulo);
        verify(casoRepositorio, times(1)).obtenerTodos();
    }

    @Test
    public void testActualizarSaldoPendiente_debeCalcularSaldoCorrectamente() {
        when(casoRepositorio.buscarPorId(1L)).thenReturn(Optional.of(casoPrueba));

        casoServicio.actualizarSaldoPendiente(1L, new BigDecimal("250000"));

        verify(casoRepositorio, times(1))
                .actualizarSaldoPendiente(1L, new BigDecimal("750000"));
    }

    @Test
    public void testActualizarSaldoPendiente_siCasoNoExiste_noDebeActualizar() {
        when(casoRepositorio.buscarPorId(99L)).thenReturn(Optional.empty());

        casoServicio.actualizarSaldoPendiente(99L, new BigDecimal("100000"));

        verify(casoRepositorio, never()).actualizarSaldoPendiente(anyLong(), any(BigDecimal.class));
    }

    @Test
    public void testActualizarSaldoPendiente_siValorTotalEsNull_debeUsarCero() {
        Caso casoSinValor = Caso.builder()
                .id(2L)
                .titulo("Caso sin valor")
                .descripcion("Sin valor total")
                .estado("ABIERTO")
                .prioridad("MEDIA")
                .fechaCreacion("2026-05-26")
                .valorTotal(null)
                .saldoPendiente(null)
                .build();

        when(casoRepositorio.buscarPorId(2L)).thenReturn(Optional.of(casoSinValor));

        casoServicio.actualizarSaldoPendiente(2L, new BigDecimal("50000"));

        verify(casoRepositorio, times(1))
                .actualizarSaldoPendiente(2L, new BigDecimal("-50000"));
    }
}
