package co.vinni.abogados.dominio.modelo;

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