package co.vinni.abogados.dominio.modelo;

import jakarta.persistence.*;

// Entidad JPA - representa la tabla "abogados" en la base de datos
@Entity
@Table(name = "abogados")
public class AbogadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Column(name = "numero_cedula", nullable = false, unique = true)
    private String numeroCedula;

    @Column(name = "tarjeta_profesional", nullable = false, unique = true)
    private String tarjetaProfesional;

    @Column(name = "especialidad", nullable = false)
    private String especialidad;

    @Column(name = "correo_electronico", nullable = false, unique = true)
    private String correoElectronico;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String n) { this.nombreCompleto = n; }
    public String getNumeroCedula() { return numeroCedula; }
    public void setNumeroCedula(String n) { this.numeroCedula = n; }
    public String getTarjetaProfesional() { return tarjetaProfesional; }
    public void setTarjetaProfesional(String t) { this.tarjetaProfesional = t; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String e) { this.especialidad = e; }
    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String c) { this.correoElectronico = c; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String t) { this.telefono = t; }
}