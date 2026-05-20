package co.vinni.casos.dominio.repositorio;
import java.util.List;

import co.vinni.casos.dominio.modelo.Caso;

public interface CasoRepositorio {
    Caso registrar(Caso caso);

    List<Caso> listarTodos();
}