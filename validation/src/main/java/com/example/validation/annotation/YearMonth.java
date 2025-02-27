package com.example.validation.annotation;

import com.example.validation.validator.YearMonthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {YearMonthValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface YearMonth {
    String message() default "연월 양식에 맞지 않습니다. yyyyMM";
    String regexp() default "^\\d{4}(0[1-9]|1[0-2])$";

    // 필수 요소 추가
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
