package co.vinni.abogados.dominio.modelo;

import jakarta.persistence.*;

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
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public String getNumeroCedula() { return numeroCedula; }
    public void setNumeroCedula(String numeroCedula) { this.numeroCedula = numeroCedula; }
    public String getTarjetaProfesional() { return tarjetaProfesional; }
    public void setTarjetaProfesional(String tarjetaProfesional) { this.tarjetaProfesional = tarjetaProfesional; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}