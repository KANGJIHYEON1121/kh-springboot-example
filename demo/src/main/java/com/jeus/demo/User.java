package com.jeus.demo;

import java.util.ArrayList;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok annotation
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @NotBlank(message = "유저ID는 필수 입력해주세요.")
    private String userId;
    @NotBlank(message = "이름은 필수 입력해주세요.")
    private String userName;
    private String userPassword;
    private String introduction;
    private String email;
    private ArrayList<String> checkBoxList;
    private String gender;
}
