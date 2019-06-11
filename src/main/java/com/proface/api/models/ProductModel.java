package com.proface.api.models;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.proface.api.models.references.ProductLineRefModel;
import com.proface.api.util.ProfaceValidationMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductModel {

	private int id;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Size(max = 20, message = ProfaceValidationMessage.MAX_SIZE)
	private String nativeId;
	
	@NotBlank(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	@Size(max = 200, message = ProfaceValidationMessage.MAX_SIZE)
	private String name;
	
	@Size(max = 300, message = ProfaceValidationMessage.MAX_SIZE)
	private String description;
	
	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private CurrencyModel currency;
	
	@PositiveOrZero(message = ProfaceValidationMessage.POSITIVE)
	private double salePrice;
	
	private double localPrice;
	
	private int totalStock;
	
	private int avaliableStock;
	
	@Valid
	@NotNull(message = ProfaceValidationMessage.NOT_NULL_BLANK)
	private ProductLineRefModel line;
	
	private List<UnitModel> units;
	
}
