package co.vinni.casos.infraestructura.persistencia;

import co.vinni.casos.aplicacion.dominio.modelo.Caso;
import co.vinni.casos.aplicacion.dominio.modelo.CasoEntity;
import co.vinni.casos.aplicacion.dominio.repositorio.CasoRepositorio;
import co.vinni.common.RadicadoDuplicadoException;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;

@ApplicationScoped
public class CasoPanacheRepositorio implements CasoRepositorio, PanacheRepository<CasoEntity> {

    @Override
    public boolean existePorRadicado(String numeroRadicado) {
        return count("numeroRadicado", numeroRadicado) > 0;
    }

    @Override
    @Transactional
    public Caso registrar(Caso caso) {
        if (existePorRadicado(caso.getNumeroRadicado())) {
            throw new RadicadoDuplicadoException(caso.getNumeroRadicado());
        }

        caso.setFechaCreacion(LocalDateTime.now());

        CasoEntity entity = new CasoEntity();
        entity.numeroRadicado  = caso.getNumeroRadicado();
        entity.fechaInicio     = caso.getFechaInicio();
        entity.tipoCaso        = caso.getTipoCaso();
        entity.estado          = caso.getEstado();
        entity.prioridad       = caso.getPrioridad();
        entity.descripcion     = caso.getDescripcion();
        entity.clienteNombre   = caso.getClienteNombre();
        entity.clienteDocumento = caso.getClienteDocumento();
        entity.clienteTelefono = caso.getClienteTelefono();
        entity.clienteCorreo   = caso.getClienteCorreo();
        entity.parteDemandada  = caso.getParteDemandada();
        entity.responsable     = caso.getResponsable();
        entity.responsableNombre = caso.getResponsableNombre();
        entity.especialidad    = caso.getEspecialidad();
        entity.observaciones   = caso.getObservaciones();
        entity.fechaCreacion   = caso.getFechaCreacion();
        entity.usuarioCreacion = caso.getUsuarioCreacion();

        persist(entity);

        caso.setId(entity.id);
        return caso;
    }
}
