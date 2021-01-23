package br.com.projectvendas.Validation.NotEmptyListValidator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.projectvendas.Validation.NotEmptyList;

public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List<?>>{

	@Override
	public boolean isValid(List<?> list, ConstraintValidatorContext context) {
 		return list != null && !list.isEmpty();
	}
	
	public void initialize(NotEmptyList constraintAnnotation) {};
   
	
}
