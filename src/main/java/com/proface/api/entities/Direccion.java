package com.proface.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "direccion")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Direccion {

	@Id
	@NonNull
	@Column(name = "id_direccion")
	private String idDireccion;
	
	@Column(name = "nombreCalle")
	private String nombreCalle;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_direccion")
	private Proveedor idProveedor;
	
	@Projection(types = Direccion.class)
	public interface DireccionView {
		@Value("#{target.idDireccion}")
	    String getIdProveedor();
		@Value("#{target.getNombreCalle().concat(', ' + target.getCiudad())}")
		String getDireccion();
	}
	
}
