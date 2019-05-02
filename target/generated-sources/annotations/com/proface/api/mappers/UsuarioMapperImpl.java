package com.proface.api.mappers;

import com.proface.api.entities.Usuario;
import com.proface.api.models.UsuarioModel;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-01T21:23:11-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioModel convertToModel(Usuario entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setFirstName( entity.getFirstName() );
        usuarioModel.setLastName( entity.getLastName() );
        usuarioModel.setEmail( entity.getEmail() );

        return usuarioModel;
    }

    @Override
    public Usuario convertToEntity(UsuarioModel model) {
        if ( model == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setFirstName( model.getFirstName() );
        usuario.setLastName( model.getLastName() );
        usuario.setEmail( model.getEmail() );

        return usuario;
    }
}
