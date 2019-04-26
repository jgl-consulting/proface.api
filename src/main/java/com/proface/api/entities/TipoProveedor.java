package com.proface.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name= "tipo_proveedor")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TipoProveedor {

	@Id
    @NonNull
	@Column(name = "id_tipo_proveedor")
    private Integer idTipoProveedor;
	
	@Column(name = "descripcion")
    private String descripcion;
	
	@Column(name = "tipo_moneda")
	private String tipoMoneda;
	
	@Projection(types = { TipoProveedor.class }) 
	public interface TipoProveedorView {
		@Value("#{target.idTipoProveedor}")
		Integer getIdTipoProveedor();
	    String getDescripcion();
	    String getTipoMoneda();
	}
	
}
