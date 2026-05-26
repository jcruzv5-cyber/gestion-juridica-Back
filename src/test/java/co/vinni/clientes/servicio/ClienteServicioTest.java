package co.vinni.clientes.servicio;

import co.vinni.clientes.aplicacion.ClienteServicio;
import co.vinni.clientes.dominio.modelo.Cliente;
import co.vinni.clientes.dominio.repositorio.ClienteRepositorio;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@QuarkusTest
public class ClienteServicioTest {

    @Inject
    ClienteServicio clienteServicio;

    @InjectMock
    ClienteRepositorio clienteRepositorio;

    private Cliente clientePrueba;

    @BeforeEach
    public void setup() {
        clientePrueba = Cliente.builder()
                .tipoDocumento("CC")
                .numeroDocumento("123456789")
                .nombres("Juan Diego")
                .apellidos("Cruz Vega")
                .fechaNacimiento(LocalDate.of(2000, 5, 15))
                .genero("Masculino")
                .estadoCivil("Soltero")
                .direccionResidencia("Calle 10 # 20 - 30")
                .ciudadMunicipio("Bogotá")
                .barrio("Centro")
                .telefonoPrincipal("3001234567")
                .telefonoSecundario("3019876543")
                .correoElectronico("correo@correo.com")
                .estratoSocioeconomico("3")
                .ingresosMensuales("2500000")
                .ocupacion("Empleado")
                .indicadorPoblacionVulnerable(false)
                .tipoPoblacionVulnerable("")
                .aceptaHabeasData(true)
                .estadoUsuario("Activo")
                .fechaRegistro(LocalDateTime.of(2026, 5, 21, 10, 30, 0))
                .build();
    }

    @Test
    public void testCrearCliente_debeInvocarRepositorioUnaVez() {
        clienteServicio.crear(clientePrueba);

        verify(clienteRepositorio, times(1)).crear(any(Cliente.class));
    }

    @Test
    public void testCrearCliente_debeEnviarTodosLosDatosCorrectosAlRepositorio() {
        clienteServicio.crear(clientePrueba);

        ArgumentCaptor<Cliente> captor = ArgumentCaptor.forClass(Cliente.class);
        verify(clienteRepositorio).crear(captor.capture());

        Cliente clienteCapturado = captor.getValue();

        assertEquals("CC", clienteCapturado.tipoDocumento);
        assertEquals("123456789", clienteCapturado.numeroDocumento);
        assertEquals("Juan Diego", clienteCapturado.nombres);
        assertEquals("Cruz Vega", clienteCapturado.apellidos);
        assertEquals(LocalDate.of(2000, 5, 15), clienteCapturado.fechaNacimiento);
        assertEquals("Masculino", clienteCapturado.genero);
        assertEquals("Soltero", clienteCapturado.estadoCivil);
        assertEquals("Calle 10 # 20 - 30", clienteCapturado.direccionResidencia);
        assertEquals("Bogotá", clienteCapturado.ciudadMunicipio);
        assertEquals("Centro", clienteCapturado.barrio);
        assertEquals("3001234567", clienteCapturado.telefonoPrincipal);
        assertEquals("3019876543", clienteCapturado.telefonoSecundario);
        assertEquals("correo@correo.com", clienteCapturado.correoElectronico);
        assertEquals("3", clienteCapturado.estratoSocioeconomico);
        assertEquals("2500000", clienteCapturado.ingresosMensuales);
        assertEquals("Empleado", clienteCapturado.ocupacion);
        assertEquals(false, clienteCapturado.indicadorPoblacionVulnerable);
        assertEquals("", clienteCapturado.tipoPoblacionVulnerable);
        assertEquals(true, clienteCapturado.aceptaHabeasData);
        assertEquals("Activo", clienteCapturado.estadoUsuario);
        assertEquals(LocalDateTime.of(2026, 5, 21, 10, 30, 0), clienteCapturado.fechaRegistro);
    }
}