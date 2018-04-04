package com.ysdevelop.common.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.ysdevelop.common.utils.RegexUtil;

public class IsTelephoneValidator implements ConstraintValidator<IsTelephone, String> {

	private boolean required = false;

	@Override
	public void initialize(IsTelephone constraintAnnotation) {
		required = constraintAnnotation.required();
	}

	@Override
	public boolean isValid(String phone, ConstraintValidatorContext context) {
		if (phone == null) {
			return true;
		}
		if (required) {
			return RegexUtil.checkPhone(phone);
		} else {
			if (StringUtils.isEmpty(phone)) {
				return true;
			} else {
				return RegexUtil.checkPhone(phone);
			}
		}
	}

}
