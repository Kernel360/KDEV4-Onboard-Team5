package com.sh.validation.validator;

import com.sh.validation.annotation.PhoneNumber;
import com.sh.validation.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.regex.Pattern;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String format;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.format = constraintAnnotation.format();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        try{
            formatter.parse(value);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
