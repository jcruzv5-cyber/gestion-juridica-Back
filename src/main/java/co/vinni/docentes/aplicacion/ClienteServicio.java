package co.vinni.docentes.aplicacion;

import co.vinni.docentes.dominio.modelo.Cliente;
import co.vinni.docentes.dominio.repositorio.ClienteRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ClienteServicio {

    @Inject
    ClienteRepositorio repositorio;

    public void crear(Cliente cliente) {
        repositorio.crear(cliente);
    }
}