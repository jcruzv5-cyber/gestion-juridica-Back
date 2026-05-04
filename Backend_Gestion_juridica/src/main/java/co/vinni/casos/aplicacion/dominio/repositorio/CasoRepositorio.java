package co.vinni.casos.dominio.repositorio;

import co.vinni.casos.dominio.modelo.Caso;

public interface CasoRepositorio {
    Caso registrar(Caso caso);
}