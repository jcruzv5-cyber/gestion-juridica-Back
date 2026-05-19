package co.vinni.casos.aplicacion.dominio.infraestructura.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class CasoDto {

    @NotBlank(message = "El número de radicado es obligatorio")
    @Size(min = 5, max = 30, message = "El radicado debe tener entre 5 y 30 caracteres")
    private String numeroRadicado;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    @NotBlank(message = "El tipo de caso es obligatorio")
    private String tipoCaso;

    private String estado;
    private String prioridad;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, max = 500, message = "La descripción debe tener entre 10 y 500 caracteres")
    private String descripcion;

    // Cliente / demandante
    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String clienteNombre;

    @NotBlank(message = "El documento del cliente es obligatorio")
    private String clienteDocumento;

    @NotBlank(message = "El teléfono del cliente es obligatorio")
    private String clienteTelefono;

    @NotBlank(message = "El correo del cliente es obligatorio")
    @Email(message = "El correo del cliente no tiene formato válido")
    private String clienteCorreo;

    // Demandado
    @NotBlank(message = "La parte demandada es obligatoria")
    private String parteDemandada;

    // Responsable
    @NotBlank(message = "El ID del responsable es obligatorio")
    private String responsable;

    private String responsableNombre;
    private String especialidad;

    @Size(max = 300, message = "Las observaciones no pueden superar 300 caracteres")
    private String observaciones;

    private String usuarioCreacion;

    // ── Getters / Setters ──────────────────────────────────────
    public String getNumeroRadicado() { return numeroRadicado; }
    public void setNumeroRadicado(String v) { this.numeroRadicado = v; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate v) { this.fechaInicio = v; }

    public String getTipoCaso() { return tipoCaso; }
    public void setTipoCaso(String v) { this.tipoCaso = v; }

    public String getEstado() { return estado; }
    public void setEstado(String v) { this.estado = v; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String v) { this.prioridad = v; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String v) { this.descripcion = v; }

    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String v) { this.clienteNombre = v; }

    public String getClienteDocumento() { return clienteDocumento; }
    public void setClienteDocumento(String v) { this.clienteDocumento = v; }

    public String getClienteTelefono() { return clienteTelefono; }
    public void setClienteTelefono(String v) { this.clienteTelefono = v; }

    public String getClienteCorreo() { return clienteCorreo; }
    public void setClienteCorreo(String v) { this.clienteCorreo = v; }

    public String getParteDemandada() { return parteDemandada; }
    public void setParteDemandada(String v) { this.parteDemandada = v; }

    public String getResponsable() { return responsable; }
    public void setResponsable(String v) { this.responsable = v; }

    public String getResponsableNombre() { return responsableNombre; }
    public void setResponsableNombre(String v) { this.responsableNombre = v; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String v) { this.especialidad = v; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String v) { this.observaciones = v; }

    public String getUsuarioCreacion() { return usuarioCreacion; }
    public void setUsuarioCreacion(String v) { this.usuarioCreacion = v; }
}