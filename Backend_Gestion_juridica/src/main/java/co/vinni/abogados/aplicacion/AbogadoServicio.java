package co.vinni.abogados.aplicacion;

import co.vinni.abogados.dominio.modelo.AbogadoEntity;
import co.vinni.abogados.infraestructura.dto.AbogadoDto;
import co.vinni.abogados.repositorio.AbogadoRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AbogadoServicio {

    @Inject
    AbogadoRepositorio abogadoRepositorio;

    @Transactional
    public AbogadoEntity registrar(AbogadoDto dto) {
        AbogadoEntity entity = new AbogadoEntity();
        entity.setNombreCompleto(dto.nombreCompleto);
        entity.setNumeroCedula(dto.numeroCedula);
        entity.setTarjetaProfesional(dto.tarjetaProfesional);
        entity.setEspecialidad(dto.especialidad);
        entity.setCorreoElectronico(dto.correoElectronico);
        entity.setTelefono(dto.telefono);
        return abogadoRepositorio.guardar(entity);
    }
}