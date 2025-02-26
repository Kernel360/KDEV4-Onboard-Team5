package com.sh.validation.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sh.validation.annotation.PhoneNumber;
import com.sh.validation.annotation.YearMonth;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {

    //@NotBlank
    private String name;
    private String nickName;

    @NotBlank
    @Size(min = 1, max = 12)
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    //@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$")
    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @YearMonth
    private String birthDate;

    @AssertTrue(message = "name or nickname 은 존재해야 합니다.")
    public boolean isNameCheck(){

        if(Objects.nonNull(name)&&!name.isBlank()){
            return true;
        }

        if(Objects.nonNull(nickName)&&!nickName.isBlank()){
            return true;
        }

        return false;
    }
}
