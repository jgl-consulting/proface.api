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
@Table(name = "cuenta")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Cuenta {

	@Id
	@NonNull
	@Column(name = "nro_cuenta")
	private String nroCuenta;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proveedor")
	private Proveedor idProveedor;
	
	@Projection(types = Cuenta.class)
	public interface CuentaView {
		String getNroCuenta();
		@Value("#{target.getIdProveedor().getIdProveedor()}")
		String getIdProveedor();
	}
	
}
