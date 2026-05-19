package co.vinni.abogados.dominio.modelo;

// Modelo de dominio - representa un abogado en la lógica del negocio
public class Abogado {
    private Long id;
    private String nombreCompleto;
    private String numeroCedula;
    private String tarjetaProfesional;
    private String especialidad;
    private String correoElectronico;
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