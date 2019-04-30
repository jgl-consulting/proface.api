package com.proface.api.mappers;

import com.proface.api.entities.Proveedor;
import com.proface.api.models.ProveedorModel;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-04-30T00:07:33-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class ProveedorMapperImpl implements ProveedorMapper {

    @Override
    public ProveedorModel convertToModel(Proveedor entity) {
        if ( entity == null ) {
            return null;
        }

        ProveedorModel proveedorModel = new ProveedorModel();

        return proveedorModel;
    }

    @Override
    public Proveedor convertToEntity(ProveedorModel model) {
        if ( model == null ) {
            return null;
        }

        Proveedor proveedor = new Proveedor();

        return proveedor;
    }
}
