package co.vinni.casos.infraestructura.persistencia;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "CASOS")
public class CasoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "casos_seq")
    @SequenceGenerator(name = "casos_seq", sequenceName = "CASOS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "numero_radicado", nullable = false, unique = true)
    private String numeroRadicado;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "tipo_caso", nullable = false)
    private String tipoCaso;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cliente", nullable = false)
    private String cliente;

    @Column(name = "parte_demandada", nullable = false)
    private String parteDemandada;

    @Column(name = "responsable", nullable = false)
    private String responsable;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "usuario_creacion")
    private String usuarioCreacion;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }

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