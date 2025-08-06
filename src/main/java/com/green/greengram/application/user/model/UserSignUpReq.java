package com.green.greengram.application.user.model;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UserSignUpReq {
    @Pattern(regexp = "^[A-Za-z0-9_]{4,50}$",
            message = "아이디는 영어, 숫자, 언더바로만 4~50자까지 가능합니다.")
    private String uid;
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{10,}$",
            message = "비밀번호는 대소문자, 숫자, 특수문자를 포함하여 10자 이상이어야 합니다.")
    private String upw;
    @Pattern(regexp = "^[가-힣]{2,10}$",
            message = "닉네임은 한글로 2~10자까지 가능합니다.")
    private String nickName;
}
