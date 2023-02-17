package com.lee.seckill.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MobileCheckValidator.class)
public @interface MobileCheck {

    boolean required() default true;

    String message() default "mobile format error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
