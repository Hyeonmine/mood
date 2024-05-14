package com.boot.mood.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserFormDto {

    //특수문자 기입 안되게

    @NotEmpty(message = "아이디는 필수 입력 값입니다.")
    @Length(min = 4,max = 16, message = "아이디 양식에 맞게 입력해주세요")
   // @Pattern(특수문자 금지, 어노테이션 순서 ? )
    private String uid;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 양식에 맞게 입력해주세요.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 8,max = 16, message = "비밀번호 양식에 맞게 입력해주세요")
    private String password;

    @NotEmpty(message = "닉네임은 필수 입력 값입니다.")
    @Length(max=8, message="닉네임은 최대 8자 까지 입력 가능합니다.")
    private String nickname;

}
