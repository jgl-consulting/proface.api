package com.proface.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "proveedor")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Proveedor {

	@Id
	@NonNull
	@Column(name = "id_proveedor")
	private String idProveedor;
	
	@Column(name = "nombre")
	private String nombre;
	
	@JoinColumn(name = "id_tipo_proveedor", referencedColumnName = "id_tipo_proveedor")
	@ManyToOne
	private TipoProveedor idTipoProveedor;
	
	@Projection(types = { Proveedor.class }) 
	public interface ProveedorView {
		@Value("#{target.idTipoProveedor}")
		Integer getIdTipoProveedor();
	    String getIdProveedor();
	    String getNombre();
	}
}
