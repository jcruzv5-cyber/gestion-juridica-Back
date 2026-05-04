package co.vinni.casos.infraestructura.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class CasoDto {

    @NotBlank(message = "El número de radicado es obligatorio")
    private String numeroRadicado;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    @NotBlank(message = "El tipo de caso es obligatorio")
    private String tipoCaso;

    private String descripcion;

    @NotBlank(message = "El cliente es obligatorio")
    private String cliente;

    @NotBlank(message = "La parte demandada es obligatoria")
    private String parteDemandada;

    @NotBlank(message = "El responsable es obligatorio")
    private String responsable;

    private String usuarioCreacion;

    public String getNumeroRadicado() { return numeroRadicado; }
    public void setNumeroRadicado(String numeroRadicado) { this.numeroRadicado = numeroRadicado; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public String getTipoCaso() { return tipoCaso; }
    public void setTipoCaso(String tipoCaso) { this.tipoCaso = tipoCaso; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getParteDemandada() { return parteDemandada; }
    public void setParteDemandada(String parteDemandada) { this.parteDemandada = parteDemandada; }
    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
    public String getUsuarioCreacion() { return usuarioCreacion; }
    public void setUsuarioCreacion(String usuarioCreacion) { this.usuarioCreacion = usuarioCreacion; }
}