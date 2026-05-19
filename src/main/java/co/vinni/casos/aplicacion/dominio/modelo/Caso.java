package co.vinni.casos.aplicacion.dominio.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Caso {
    private Long id;
    private String numeroRadicado;
    private LocalDate fechaInicio;
    private String tipoCaso;
    private String estado;
    private String prioridad;
    private String descripcion;

    // Datos del cliente / demandante
    private String clienteNombre;
    private String clienteDocumento;
    private String clienteTelefono;
    private String clienteCorreo;

    // Parte demandada
    private String parteDemandada;

    // Responsable / abogado
    private String responsable;
    private String responsableNombre;
    private String especialidad;
    private String observaciones;

    // Auditoría
    private LocalDateTime fechaCreacion;
    private String usuarioCreacion;

    // ── Getters / Setters ──────────────────────────────────────
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroRadicado() { return numeroRadicado; }
    public void setNumeroRadicado(String numeroRadicado) { this.numeroRadicado = numeroRadicado; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getTipoCaso() { return tipoCaso; }
    public void setTipoCaso(String tipoCaso) { this.tipoCaso = tipoCaso; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }

    public String getClienteDocumento() { return clienteDocumento; }
    public void setClienteDocumento(String clienteDocumento) { this.clienteDocumento = clienteDocumento; }

    public String getClienteTelefono() { return clienteTelefono; }
    public void setClienteTelefono(String clienteTelefono) { this.clienteTelefono = clienteTelefono; }

    public String getClienteCorreo() { return clienteCorreo; }
    public void setClienteCorreo(String clienteCorreo) { this.clienteCorreo = clienteCorreo; }

    public String getParteDemandada() { return parteDemandada; }
    public void setParteDemandada(String parteDemandada) { this.parteDemandada = parteDemandada; }

    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }

    public String getResponsableNombre() { return responsableNombre; }
    public void setResponsableNombre(String responsableNombre) { this.responsableNombre = responsableNombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getUsuarioCreacion() { return usuarioCreacion; }
    public void setUsuarioCreacion(String usuarioCreacion) { this.usuarioCreacion = usuarioCreacion; }
}