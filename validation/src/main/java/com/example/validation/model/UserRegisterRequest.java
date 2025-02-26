package com.example.validation.model;

import com.example.validation.annotation.PhoneNumber;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {
/*    @NotNull // != null
    @NotEmpty*/

    //@NotBlank // != null & not empty
    private String name;

    private String nickname;

    @Size(min = 1, max = 12)
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    // 정규식 화용
    //@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식에 맞지 않습니다.")
    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    // name or nickname 하나만 있어도 가능
    @AssertTrue(message = "name 또는 nickname 은 반드시 1개가 존재해야 합니다.")
    public boolean isNameCheck() {
        if (Objects.nonNull(name) && !name.isBlank()) {
            return true;
        }

        if (Objects.nonNull(nickname) && !nickname.isBlank()) {
            return true;
        }

        return false;
    }
}
