package com.toxic.spring.udemy.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode constraintAnnotation) {
		coursePrefix = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext ctx) {
		boolean result;
		if (theCode!=null) {
			result = theCode.startsWith(coursePrefix);
		} else {
			result=false;
		}
		return result;
	}

}
