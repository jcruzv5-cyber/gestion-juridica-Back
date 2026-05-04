package co.vinni.casos.dominio.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Caso {
    private Long id;
    private String numeroRadicado;
    private LocalDate fechaInicio;
    private String tipoCaso;
    private String descripcion;
    private String cliente;
    private String parteDemandada;
    private String responsable;
    private LocalDateTime fechaCreacion;
    private String usuarioCreacion;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public String getUsuarioCreacion() { return usuarioCreacion; }
    public void setUsuarioCreacion(String usuarioCreacion) { this.usuarioCreacion = usuarioCreacion; }
}