package com.sh.validation.annotation;

import com.sh.validation.validator.PhoneNumberValidator;
import com.sh.validation.validator.YearMonthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = YearMonthValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface YearMonth {
    String message() default "날짜 형식이 맞지 않습니다 ex) yyyyMM";
    String format() default "yyyyMM";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
