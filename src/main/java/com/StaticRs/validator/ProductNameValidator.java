package com.StaticRs.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.StaticRs.pojo.Product;

@Component
public class ProductNameValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Product p= (Product) target;
		if(!p.getName().contains("TMT"))
			errors.rejectValue("name", "product.name.containErr");
		
	}

}
