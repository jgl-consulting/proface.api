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
@Table(name = "contacto")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Contacto {

	@Id
	@NonNull
	@Column(name = "id_contacto")
	private String idContacto;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_contacto")
	private Proveedor idProveedor;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "correo")
	private String correo;
	
	@Projection(types = Contacto.class)
	public interface ContactoView {
		@Value("#{target.idContacto}")
	    String getIdProveedor();
		@Value("#{target.getNombre().concat(' ' + target.getApellido())}")
	    String getNombres();
		String getTelefono();
		String getCorreo();
	}
	
}
