package co.vinni.abogados.repositorio;

import co.vinni.abogados.dominio.modelo.AbogadoEntity;

// Interfaz que define las operaciones de base de datos para abogados
public interface AbogadoRepositorio {
    AbogadoEntity guardar(AbogadoEntity abogado);
}