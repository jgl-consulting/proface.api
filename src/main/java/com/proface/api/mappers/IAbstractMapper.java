package com.proface.api.mappers;

/**
 * 
 * @author josec
 * This class abstracts the basic Model to Entity and Entity to Model methods
 * @param <M>	Model
 * @param <E>	Entity
 */
public interface IAbstractMapper <M,E> {
	
	/**
	 * Converts Entity to Model
	 * Must share attributes names
	 * @param entity
	 * @return model
	 */
	M convertToModel(E entity);

	/**
	 * Converts Model to Entity
	 * Must share attributes names 
	 * @param model
	 * @return entity
	 */
	E convertToEntity(M model);
}
