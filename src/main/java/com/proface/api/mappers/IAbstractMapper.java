package com.proface.api.mappers;

public interface IAbstractMapper <M,E> {

	M convertToModel(E entity);

	E convertToEntity(M model);
}
