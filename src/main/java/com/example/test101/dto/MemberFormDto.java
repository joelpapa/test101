package com.example.test101.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class MemberFormDto {
    @NotBlank(message="아이디는 필수입니다.")
    private String memberid;

    @NotEmpty(message="이름은 필수입니다.")
    private String name;

    @NotEmpty(message="배송정보 등을 알려드립니다. 입력해주세요")
    @Email(message = "이메일 형식으로 넣어주세요")
    private String email;

    @NotEmpty(message="비밀번호는 필수입니다.")
    @Length(min=8, max=16, message="8자 이상, 16자 이하로 입력해주세요")
    private String password;

    @NotEmpty(message="배송정보 등을 알려드립니다. 입력해주세요")
    private String mobile;
}
