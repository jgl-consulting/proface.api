package com.proface.api.mappers;

import com.proface.api.entities.Contacto;
import com.proface.api.entities.Cuenta;
import com.proface.api.entities.Direccion;
import com.proface.api.entities.Proveedor;
import com.proface.api.entities.TipoProveedor;
import com.proface.api.models.ContactoModel;
import com.proface.api.models.CuentaModel;
import com.proface.api.models.DireccionModel;
import com.proface.api.models.ProveedorModel;
import com.proface.api.models.TipoProveedorModel;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-03T08:31:18-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_172 (Oracle Corporation)"
)
@Component
public class ProveedorMapperImpl implements ProveedorMapper {

    @Override
    public ProveedorModel convertToModel(Proveedor entity) {
        if ( entity == null ) {
            return null;
        }

        ProveedorModel proveedorModel = new ProveedorModel();

        proveedorModel.setIdProveedor( entity.getIdProveedor() );
        proveedorModel.setNombre( entity.getNombre() );
        proveedorModel.setTipoProveedor( tipoProveedorToTipoProveedorModel( entity.getTipoProveedor() ) );
        proveedorModel.setContacto( contactoToContactoModel( entity.getContacto() ) );
        proveedorModel.setCuenta( cuentaToCuentaModel( entity.getCuenta() ) );
        proveedorModel.setDireccion( direccionToDireccionModel( entity.getDireccion() ) );

        return proveedorModel;
    }

    @Override
    public Proveedor convertToEntity(ProveedorModel model) {
        if ( model == null ) {
            return null;
        }

        Proveedor proveedor = new Proveedor();

        proveedor.setIdProveedor( model.getIdProveedor() );
        proveedor.setNombre( model.getNombre() );
        proveedor.setTipoProveedor( tipoProveedorModelToTipoProveedor( model.getTipoProveedor() ) );
        proveedor.setContacto( contactoModelToContacto( model.getContacto() ) );
        proveedor.setCuenta( cuentaModelToCuenta( model.getCuenta() ) );
        proveedor.setDireccion( direccionModelToDireccion( model.getDireccion() ) );

        return proveedor;
    }

    protected TipoProveedorModel tipoProveedorToTipoProveedorModel(TipoProveedor tipoProveedor) {
        if ( tipoProveedor == null ) {
            return null;
        }

        TipoProveedorModel tipoProveedorModel = new TipoProveedorModel();

        tipoProveedorModel.setIdTipoProveedor( tipoProveedor.getIdTipoProveedor() );
        tipoProveedorModel.setDescripcion( tipoProveedor.getDescripcion() );
        tipoProveedorModel.setTipoMoneda( tipoProveedor.getTipoMoneda() );

        return tipoProveedorModel;
    }

    protected ContactoModel contactoToContactoModel(Contacto contacto) {
        if ( contacto == null ) {
            return null;
        }

        ContactoModel contactoModel = new ContactoModel();

        contactoModel.setNombre( contacto.getNombre() );
        contactoModel.setApellido( contacto.getApellido() );
        contactoModel.setTelefono( contacto.getTelefono() );
        contactoModel.setCorreo( contacto.getCorreo() );

        return contactoModel;
    }

    protected CuentaModel cuentaToCuentaModel(Cuenta cuenta) {
        if ( cuenta == null ) {
            return null;
        }

        CuentaModel cuentaModel = new CuentaModel();

        cuentaModel.setNroCuenta( cuenta.getNroCuenta() );

        return cuentaModel;
    }

    protected DireccionModel direccionToDireccionModel(Direccion direccion) {
        if ( direccion == null ) {
            return null;
        }

        DireccionModel direccionModel = new DireccionModel();

        direccionModel.setNombreCalle( direccion.getNombreCalle() );
        direccionModel.setCiudad( direccion.getCiudad() );

        return direccionModel;
    }

    protected TipoProveedor tipoProveedorModelToTipoProveedor(TipoProveedorModel tipoProveedorModel) {
        if ( tipoProveedorModel == null ) {
            return null;
        }

        TipoProveedor tipoProveedor = new TipoProveedor();

        tipoProveedor.setIdTipoProveedor( tipoProveedorModel.getIdTipoProveedor() );
        tipoProveedor.setDescripcion( tipoProveedorModel.getDescripcion() );
        tipoProveedor.setTipoMoneda( tipoProveedorModel.getTipoMoneda() );

        return tipoProveedor;
    }

    protected Contacto contactoModelToContacto(ContactoModel contactoModel) {
        if ( contactoModel == null ) {
            return null;
        }

        Contacto contacto = new Contacto();

        contacto.setNombre( contactoModel.getNombre() );
        contacto.setApellido( contactoModel.getApellido() );
        contacto.setTelefono( contactoModel.getTelefono() );
        contacto.setCorreo( contactoModel.getCorreo() );

        return contacto;
    }

    protected Cuenta cuentaModelToCuenta(CuentaModel cuentaModel) {
        if ( cuentaModel == null ) {
            return null;
        }

        Cuenta cuenta = new Cuenta();

        cuenta.setNroCuenta( cuentaModel.getNroCuenta() );

        return cuenta;
    }

    protected Direccion direccionModelToDireccion(DireccionModel direccionModel) {
        if ( direccionModel == null ) {
            return null;
        }

        Direccion direccion = new Direccion();

        direccion.setNombreCalle( direccionModel.getNombreCalle() );
        direccion.setCiudad( direccionModel.getCiudad() );

        return direccion;
    }
}
