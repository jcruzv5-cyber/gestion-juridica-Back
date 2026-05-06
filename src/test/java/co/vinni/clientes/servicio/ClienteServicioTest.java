package co.vinni.clientes.servicio;

import co.vinni.clientes.aplicacion.ClienteServicio;
import co.vinni.clientes.dominio.modelo.Cliente;
import co.vinni.clientes.dominio.repositorio.ClienteRepositorio;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
                .correoElectronico("correo@correo.com")
                .telefonoPrincipal("3001234567")
                .aceptaHabeasData(true)
                .estadoUsuario("Activo")
                .build();
    }

    @Test
    public void testCrearCliente() {
        clienteServicio.crear(clientePrueba);
        verify(clienteRepositorio, times(1)).crear(any(Cliente.class));
    }
}