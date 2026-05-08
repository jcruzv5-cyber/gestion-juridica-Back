package co.vinni.abogados.repositorio;

import co.vinni.abogados.dominio.modelo.AbogadoEntity;

public interface AbogadoRepositorio {
    AbogadoEntity guardar(AbogadoEntity abogado);
}