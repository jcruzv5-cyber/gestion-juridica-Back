package co.vinni.casos.dominio.repositorio;

import co.vinni.casos.dominio.modelo.Caso;

import java.util.List;

public interface CasoRepositorio {
    void crear(Caso caso);
    List<Caso> obtenerTodos();
}
