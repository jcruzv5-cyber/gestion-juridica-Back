package co.vinni.abogados;

import co.vinni.abogados.aplicacion.AbogadoServicio;
import co.vinni.abogados.dominio.modelo.AbogadoEntity;
import co.vinni.abogados.infraestructura.dto.AbogadoDto;
import co.vinni.abogados.repositorio.AbogadoRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AbogadoServicioTest {

    @Mock
    AbogadoRepositorio abogadoRepositorio;

    @InjectMocks
    AbogadoServicio abogadoServicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void debeRegistrarAbogadoCorrectamente() {
        AbogadoDto dto = new AbogadoDto();
        dto.nombreCompleto = "Juan Perez";
        dto.numeroCedula = "123456";
        dto.tarjetaProfesional = "TP001";
        dto.especialidad = "Civil";
        dto.correoElectronico = "juan@test.com";
        dto.telefono = "3001234567";

        AbogadoEntity entityEsperada = new AbogadoEntity();
        entityEsperada.setNombreCompleto(dto.nombreCompleto);
        entityEsperada.setNumeroCedula(dto.numeroCedula);
        entityEsperada.setTarjetaProfesional(dto.tarjetaProfesional);
        entityEsperada.setEspecialidad(dto.especialidad);
        entityEsperada.setCorreoElectronico(dto.correoElectronico);
        entityEsperada.setTelefono(dto.telefono);

        when(abogadoRepositorio.guardar(any(AbogadoEntity.class))).thenReturn(entityEsperada);

        AbogadoEntity resultado = abogadoServicio.registrar(dto);

        assertNotNull(resultado);
        assertEquals("Juan Perez", resultado.getNombreCompleto());
        assertEquals("123456", resultado.getNumeroCedula());
        verify(abogadoRepositorio, times(1)).guardar(any(AbogadoEntity.class));
    }

    @Test
    void debeMappearTodosLosCamposDelDto() {
        AbogadoDto dto = new AbogadoDto();
        dto.nombreCompleto = "Maria Lopez";
        dto.numeroCedula = "654321";
        dto.tarjetaProfesional = "TP002";
        dto.especialidad = "Penal";
        dto.correoElectronico = "maria@test.com";
        dto.telefono = "3009876543";

        AbogadoEntity entityEsperada = new AbogadoEntity();
        entityEsperada.setNombreCompleto(dto.nombreCompleto);
        entityEsperada.setNumeroCedula(dto.numeroCedula);
        entityEsperada.setTarjetaProfesional(dto.tarjetaProfesional);
        entityEsperada.setEspecialidad(dto.especialidad);
        entityEsperada.setCorreoElectronico(dto.correoElectronico);
        entityEsperada.setTelefono(dto.telefono);

        when(abogadoRepositorio.guardar(any(AbogadoEntity.class))).thenReturn(entityEsperada);

        AbogadoEntity resultado = abogadoServicio.registrar(dto);

        assertEquals("Maria Lopez", resultado.getNombreCompleto());
        assertEquals("TP002", resultado.getTarjetaProfesional());
        assertEquals("Penal", resultado.getEspecialidad());
        assertEquals("maria@test.com", resultado.getCorreoElectronico());
    }
}