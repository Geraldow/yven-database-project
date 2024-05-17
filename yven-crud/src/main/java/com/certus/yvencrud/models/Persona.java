package com.certus.yvencrud.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@SuppressWarnings("serial")
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByTipoDocumento", query = "SELECT p FROM Persona p WHERE p.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Persona.findByNumeroDocumento", query = "SELECT p FROM Persona p WHERE p.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Persona.findByPrimerApellido", query = "SELECT p FROM Persona p WHERE p.primerApellido = :primerApellido"),
    @NamedQuery(name = "Persona.findBySegundoApellido", query = "SELECT p FROM Persona p WHERE p.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Persona.findByNombres", query = "SELECT p FROM Persona p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Persona.findBySexo", query = "SELECT p FROM Persona p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Persona.findByEstadoCivil", query = "SELECT p FROM Persona p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Persona.findByUbigeo", query = "SELECT p FROM Persona p WHERE p.ubigeo = :ubigeo")
})

public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "tipoDocumento")
    private String tipoDocumento;

    @Column(name = "numeroDocumento")
    private Integer numeroDocumento;

    @Column(name = "primerApellido")
    private String primerApellido;

    @Column(name = "segundoApellido")
    private String segundoApellido;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "estadoCivil")
    private String estadoCivil;

    @Column(name = "ubigeo")
    private Integer ubigeo;

    // Getters and Setters

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Integer getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Integer ubigeo) {
        this.ubigeo = ubigeo;
    }
    
    public Persona() {}

    // Constructor
    public Persona(String tipoDocumento, Integer numeroDocumento, String primerApellido, String segundoApellido, String nombres, String fechaNacimiento, String sexo, String estadoCivil, Integer ubigeo) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.ubigeo = ubigeo;
    }

    @Override
    public String toString() {
        return "Persona [tipoDocumento=" + tipoDocumento +
                ", numeroDocumento=" + numeroDocumento +
                ", primerApellido=" + primerApellido +
                ", segundoApellido=" + segundoApellido +
                ", nombres=" + nombres +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sexo=" + sexo +
                ", estadoCivil=" + estadoCivil +
                ", ubigeo=" + ubigeo +
                "]";
    }
}
