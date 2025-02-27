package com.example.validation.model;

import com.example.validation.annotation.PhoneNumber;
import com.example.validation.annotation.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {
    //    @NotNull    // is null
//    @NotEmpty   // is null && name != ""
//    @NotBlank   // is null && name != "" && name != " "
    private String name;

    private String nickName;

    @Size(min = 1, max = 12)
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @YearMonth
    private String birthMonth;

    @Email
    private String email;

    @PhoneNumber
//    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식에 맞지 않습니다.")
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @AssertTrue(message = "name or nickName 은 존재해야 합니다.")
    public boolean nameCheck(){
        if(!name.isBlank()){
            return true;
        }

        if(!nickName.isBlank()){
            return true;
        }

        return false;
    }
}
