package com.proface.api.mappers;

import com.proface.api.entities.Usuario;
import com.proface.api.models.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper extends IAbstractMapper<UsuarioModel, Usuario> {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

}