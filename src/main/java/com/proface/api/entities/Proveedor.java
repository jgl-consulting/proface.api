package com.proface.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
	@Column
	private String nombre;
	
	@JoinColumn(name = "id_tipo_proveedor", referencedColumnName = "id_tipo_proveedor")
	@ManyToOne
	private TipoProveedor tipoProveedor;
	
	@OneToOne(mappedBy = "idProveedor", fetch = FetchType.LAZY)
	private Contacto contacto;
	
	@OneToOne(mappedBy = "idProveedor", fetch = FetchType.LAZY)
	private Cuenta cuenta;
	
	@OneToOne(mappedBy = "idProveedor", fetch = FetchType.LAZY)
	private Direccion direccion;
	
	@Projection(types = { Proveedor.class }) 
	public interface ProveedorView {
		@Value("#{target.idProveedor}")
	    String getIdProveedor();
	    String getNombre();
		@Value("#{target.getTipoProveedor().getDescripcion()}")
		String getTipoProveedor();
		@Value("#{target.getContacto()}")
		Contacto getContacto();
		@Value("#{target.getCuenta()}")
		Cuenta getCuenta();
		@Value("#{target.getDireccion()}")
		Direccion getDireccion();
	}
}
