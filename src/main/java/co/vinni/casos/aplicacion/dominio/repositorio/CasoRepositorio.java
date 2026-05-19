package co.vinni.casos.aplicacion.dominio.repositorio;

import co.vinni.casos.aplicacion.dominio.modelo.Caso;

public interface CasoRepositorio {
    Caso registrar(Caso caso);
    boolean existePorRadicado(String numeroRadicado);
}