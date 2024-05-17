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
@Table(name = "tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t"),
    @NamedQuery(name = "Tarjeta.findByIdTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.idTarjeta = :idTarjeta"),
    @NamedQuery(name = "Tarjeta.findByTipoTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.tipoTarjeta = :tipoTarjeta"),
    @NamedQuery(name = "Tarjeta.findByNombreTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.nombreTarjeta = :nombreTarjeta"),
    @NamedQuery(name = "Tarjeta.findByNumeroTarjeta", query = "SELECT t FROM Tarjeta t WHERE t.numeroTarjeta = :numeroTarjeta"),
    @NamedQuery(name = "Tarjeta.findByTiempoExpiracion", query = "SELECT t FROM Tarjeta t WHERE t.tiempoExpiracion = :tiempoExpiracion"),
    @NamedQuery(name = "Tarjeta.findByCodigoSeguridad", query = "SELECT t FROM Tarjeta t WHERE t.codigoSeguridad = :codigoSeguridad"),
    @NamedQuery(name = "Tarjeta.findByCvc", query = "SELECT t FROM Tarjeta t WHERE t.cvc = :cvc"),
    @NamedQuery(name = "Tarjeta.findByCvv", query = "SELECT t FROM Tarjeta t WHERE t.cvv = :cvv"),
    @NamedQuery(name = "Tarjeta.findByDireccion", query = "SELECT t FROM Tarjeta t WHERE t.direccion = :direccion"),
    @NamedQuery(name = "Tarjeta.findByCiudad", query = "SELECT t FROM Tarjeta t WHERE t.ciudad = :ciudad")
})

public class Tarjeta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) // CAMPO OBLIGATORIO
    @Column(name = "idTarjeta")
    private Integer idTarjeta;
    
    @Column(name = "tipoTarjeta")
    private String tipoTarjeta;
    
    @Column(name = "nombreTarjeta")
    private String nombreTarjeta;
    
    @Column(name = "numeroTarjeta")
    private Integer numeroTarjeta;
    
    @Column(name = "tiempoExpiracion")
    private String tiempoExpiracion;
    
    @Column(name = "codigoSeguridad")
    private Integer codigoSeguridad;
    
    @Column(name = "cvc")
    private int cvc;
    
    @Column(name = "cvv")
    private int cvv;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "ciudad")
    private String ciudad;
    
    public Tarjeta() {
        
    }

    public Tarjeta(Integer idTarjeta, String tipoTarjeta) {
        this.idTarjeta = idTarjeta;
        this.tipoTarjeta = tipoTarjeta;
    }
    
    public Integer getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public Integer getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(Integer numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTiempoExpiracion() {
        return tiempoExpiracion;
    }

    public void setTiempoExpiracion(String tiempoExpiracion) {
        this.tiempoExpiracion = tiempoExpiracion;
    }

    public Integer getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(Integer codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public Tarjeta(String tipoTarjeta, 
                   Integer idTarjeta, 
                   String nombreTarjeta, 
                   Integer numeroTarjeta, 
                   String tiempoExpiracion, 
                   Integer codigoSeguridad, 
                   int cvc, 
                   int cvv, 
                   String direccion, 
                   String ciudad) {
        this.tipoTarjeta = tipoTarjeta;
        this.idTarjeta = idTarjeta;
        this.nombreTarjeta = nombreTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.tiempoExpiracion = tiempoExpiracion;
        this.codigoSeguridad = codigoSeguridad;
        this.cvc = cvc;
        this.cvv = cvv;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }
}
