package cl.bicevida.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "persona_pers")
public class Persona {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "rut")
    private String rut;

    @Column(name = "dv")
    private String dv;

    @Column(name = "nombres_razon_social")
    private String nombresRazonSocial;

    @Column(name = "apellido_1")
    private String apellido1;

    @Column(name = "apellido_2")
    private String apellido2;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "email")
    private String email;

    // Getter y Setter para cada variable

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombresRazonSocial() {
        return nombresRazonSocial;
    }

    public void setNombresRazonSocial(String nombresRazonSocial) {
        this.nombresRazonSocial = nombresRazonSocial;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}