package co.vinni.abogados.servicio;

import co.vinni.abogados.aplicacion.AbogadoServicio;
import co.vinni.abogados.dominio.modelo.AbogadoEntity;
import co.vinni.abogados.infraestructura.dto.AbogadoDto;
import co.vinni.abogados.repositorio.AbogadoRepositorio;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@QuarkusTest
public class AbogadoServicioTest {

    @Inject
    AbogadoServicio abogadoServicio;

    @InjectMock
    AbogadoRepositorio abogadoRepositorio;

    private AbogadoDto abogadoDtoPrueba;

    @BeforeEach
    public void setup() {
        abogadoDtoPrueba = new AbogadoDto();
        abogadoDtoPrueba.nombreCompleto = "Juan Carlos Pérez";
        abogadoDtoPrueba.numeroCedula = "123456789";
        abogadoDtoPrueba.tarjetaProfesional = "TP-987654";
        abogadoDtoPrueba.especialidad = "Derecho Civil";
        abogadoDtoPrueba.correoElectronico = "juan.perez@correo.com";
        abogadoDtoPrueba.telefono = "3001234567";
    }

    @Test
    public void testRegistrarAbogado_debeInvocarRepositorioUnaVez() {
        when(abogadoRepositorio.guardar(any(AbogadoEntity.class)))
                .thenReturn(new AbogadoEntity());

        abogadoServicio.registrar(abogadoDtoPrueba);

        verify(abogadoRepositorio, times(1)).guardar(any(AbogadoEntity.class));
    }

    @Test
    public void testRegistrarAbogado_debeEnviarDatosCorrectosAlRepositorio() {
        when(abogadoRepositorio.guardar(any(AbogadoEntity.class)))
                .thenReturn(new AbogadoEntity());

        abogadoServicio.registrar(abogadoDtoPrueba);

        ArgumentCaptor<AbogadoEntity> captor = ArgumentCaptor.forClass(AbogadoEntity.class);
        verify(abogadoRepositorio).guardar(captor.capture());

        AbogadoEntity entityCapturada = captor.getValue();

        assertEquals("Juan Carlos Pérez", entityCapturada.getNombreCompleto());
        assertEquals("123456789", entityCapturada.getNumeroCedula());
        assertEquals("TP-987654", entityCapturada.getTarjetaProfesional());
        assertEquals("Derecho Civil", entityCapturada.getEspecialidad());
        assertEquals("juan.perez@correo.com", entityCapturada.getCorreoElectronico());
        assertEquals("3001234567", entityCapturada.getTelefono());
    }
}