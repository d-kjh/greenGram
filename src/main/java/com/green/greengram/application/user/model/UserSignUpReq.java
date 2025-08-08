package com.green.greengram.application.user.model;

import com.green.greengram.config.enumcode.model.EnumUserRole;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class UserSignUpReq {
    @NotNull(message = "아이디는 필수로 입력하셔야 합니다.")
    @Pattern(regexp = "^[A-Za-z0-9_]{4,20}$",
            message = "아이디는 영어, 숫자, 언더바로만 4~20자까지 가능합니다.")
    private String uid;

    @NotNull(message = "비밀번호는 필수로 입력하셔야 합니다.")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{4,}$",
            message = "비밀번호는 대소문자, 숫자, 특수문자를 포함하여 4자 이상이어야 합니다.")
    private String upw;

    @Pattern(regexp = "^[가-힣]{2,10}$",
            message = "닉네임은 한글로 2~10자까지 가능합니다.")
    private String nickName;

    private List<EnumUserRole> roles;
}
