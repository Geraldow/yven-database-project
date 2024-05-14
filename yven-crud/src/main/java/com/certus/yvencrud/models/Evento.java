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
@Table ( name = "evento")
@XmlRootElement
@NamedQueries ({
	@NamedQuery (name = "Evento.findAll" , query = "SELECT e FROM Evento e"),
	@NamedQuery(name = "Evento.findByIdPelicula", query="SELECT e FROM Evento e WHERE e.idEvento= :idEvento"),
	@NamedQuery(name = "Evento.findByNombre", query = "SELECT e FROM Evento e WHERE e.tituloEvento = :tituloEvento"),
    @NamedQuery(name = "Evento.findByDuracion", query = "SELECT e FROM Evento e WHERE e.descripcionEvento = :descripcionEvento"),
    @NamedQuery(name = "Evento.findByClasificacion", query = "SELECT e FROM Evento e WHERE e.ubicacionEvento= :ubicacionEvento"),
    @NamedQuery(name = "Evento.findByIdioma", query = "SELECT e FROM Evento e WHERE e.tipoEvento = :tipoEvento"),
    @NamedQuery(name = "Evento.findByGenero", query = "SELECT e FROM Evento e WHERE e.fechaEvento = :fechaEvento"),
    @NamedQuery(name = "Evento.findByFormato", query = "SELECT e FROM Evento e WHERE e.horaInicio = :horaInicio"),
    @NamedQuery(name = "Evento.findBySinopsis", query = "SELECT e FROM Evento e WHERE e.horaFinalizacion = :horaFinalizacion"),
    @NamedQuery(name = "Evento.findByIdioma", query = "SELECT e FROM Evento e WHERE e.capacidadEvento = :capacidadEvento"),
    @NamedQuery(name = "Evento.findByGenero", query = "SELECT e FROM Evento e WHERE e.estadoEvento = :estadoEvento"),
    @NamedQuery(name = "Evento.findByFormato", query = "SELECT e FROM Evento e WHERE e.precioEntrada = :precioEntrada"),
    @NamedQuery(name = "Evento.findBySinopsis", query = "SELECT e FROM Evento e WHERE e.catering = :catering"),
    @NamedQuery(name = "Evento.findByFormato", query = "SELECT e FROM Evento e WHERE e.presupuesto = :presupuesto"),
    @NamedQuery(name = "Evento.findBySinopsis", query = "SELECT e FROM Evento e WHERE e.organizadorId = :organizadorId")
	
})

public class Evento implements Serializable {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Basic ( optional = false ) // CAMPO OBLIGATORIO
	@Column ( name = "idEvento")
	private Integer idEvento;
	
	@Column(name = "tituloEvento")
	private String tituloEvento;
	
	@Basic(optional = false)
	@Column(name = "descripcionEvento")
	private String descripcionEvento;
	
	
	@Column(name= "ubicacionEvento")
	private String ubicacionEvento;
	
	@Column(name = "tipoEvento")
	private String tipoEvento;
	
	@Column(name="fechaEvento")
	private String fechaEvento;
	
	@Column(name = "horaInicio")
	private String horaInicio;
	
	@Column(name = "horaFinalizacion")
		private String horaFinalizacion;
	
	@Column(name = "capacidadEvento")
		private Integer capacidadEvento;
	
	@Column(name = "estadoEvento")
		private Boolean estadoEvento;
	
	@Column(name = "precioEntrada")
		private Double precioEntrada;
	
	@Column(name = "catering")
		private String catering;
	
	@Column(name = "presupuesto")
		private Double presupuesto;
	
	@Column(name = "organizadorId")
		private Integer organizadorId;
	
	public Evento() {
		
	}
	
	public Evento ( Integer idEvento, String tituloEvento) {
		this.idEvento = idEvento;
		this.tituloEvento = tituloEvento;
	}
	
	  public Integer getIdEvento() {
		    return idEvento;
		  }

		  public void setIdEvento(Integer idEvento) {
		    this.idEvento = idEvento;
		  }

		  public String getTituloEvento() {
		    return tituloEvento;
		  }

		  public void setTituloEvento(String tituloEvento) {
		    this.tituloEvento = tituloEvento;
		  }

		  public String getDescripcionEvento() {
		    return descripcionEvento;
		  }

		  public void setDescripcionEvento(String descripcionEvento) {
		    this.descripcionEvento = descripcionEvento;
		  }

		  public String getUbicacionEvento() {
		    return ubicacionEvento;
		  }

		  public void setUbicacionEvento(String ubicacionEvento) {
		    this.ubicacionEvento = ubicacionEvento;
		  }

		  public String getTipoEvento() {
		    return tipoEvento;
		  }

		  public void setTipoEvento(String tipoEvento) {
		    this.tipoEvento = tipoEvento;
		  }

		  public String getFechaEvento() {
		    return fechaEvento;
		  }

		  public void setFechaEvento(String fechaEvento) {
		    this.fechaEvento = fechaEvento.toString(); 
		  }

		  public String getHoraInicio() {
		    return horaInicio;
		  }

		  public void setHoraInicio(String horaInicio) {
		    this.horaInicio = horaInicio.toString();
		  }

		  public String getHoraFinalizacion() {
		    return horaFinalizacion;
		  }

		  public void setHoraFinalizacion(String horaFinalizacion) {
		    this.horaFinalizacion = horaFinalizacion.toString();
		  }

		  public Integer getCapacidadEvento() {
		    return capacidadEvento;
		  }

		  public void setCapacidadEvento(Integer capacidadEvento) {
		    this.capacidadEvento = capacidadEvento;
		  }

		  public Boolean getEstadoEvento() {
		    return estadoEvento;
		  }

		  public void setEstadoEvento(Boolean estadoEvento) {
		    this.estadoEvento = estadoEvento;
		  }

		  public Double getPrecioEntrada() {
		    return precioEntrada;
		  }

		  public void setPrecioEntrada(Double precioEntrada) {
		    this.precioEntrada = precioEntrada;
		  }

		  public String getCatering() {
		    return catering;
		  }

		  public void setCatering(String catering) {
		    this.catering = catering;
		  }

		  public Double getPresupuesto() {
		    return presupuesto;
		  }

		  public void setPresupuesto(Double presupuesto) {
		    this.presupuesto = presupuesto;
		  }

		  public Integer getOrganizadorId() {
		    return organizadorId;
		  }

		  public void setOrganizadorId(Integer organizadorId) {
		    this.organizadorId = organizadorId;
		  }
}	