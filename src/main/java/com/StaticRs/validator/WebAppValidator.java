package com.StaticRs.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.StaticRs.pojo.Product;

@Component
public class WebAppValidator implements Validator {
	@Autowired
	private javax.validation.Validator beanValidator;

	public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}

	private Set<Validator> springValidators;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

		Set<ConstraintViolation<Object>> beans = this.beanValidator.validate(target);
		for (ConstraintViolation<Object> obj : beans) {
			errors.rejectValue(obj.getPropertyPath().toString(), obj.getMessageTemplate(), obj.getMessage());
		}
		for (Validator v : this.springValidators) {
			v.validate(target, errors);
		}
	}

}
