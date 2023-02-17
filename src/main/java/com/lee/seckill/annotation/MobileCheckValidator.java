package com.lee.seckill.annotation;

import com.lee.seckill.util.ValidationUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileCheckValidator implements ConstraintValidator<MobileCheck, String> {
    private boolean required = false;

    @Override
    public void initialize(MobileCheck annotation) {
        required = annotation.required();
    }

    @Override
    public boolean isValid(String mobile, ConstraintValidatorContext context) {
        if (required || StringUtils.hasLength(mobile)) {
            return ValidationUtil.isMobile(mobile);
        } else {
            return true;
        }
    }
}
