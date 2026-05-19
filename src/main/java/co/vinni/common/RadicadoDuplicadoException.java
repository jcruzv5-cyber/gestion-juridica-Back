package co.vinni.common;

public class RadicadoDuplicadoException extends RuntimeException {

    private final String numeroRadicado;

    public RadicadoDuplicadoException(String numeroRadicado) {
        super("El número de radicado '" + numeroRadicado + "' ya está registrado en el sistema");
        this.numeroRadicado = numeroRadicado;
    }

    public String getNumeroRadicado() {
        return numeroRadicado;
    }
}
