package com.kh.springbootinterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.springbootinterceptor.domain.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
    @GetMapping("/login")
    // 1. 사용자 요청정보 수신.
    public String loginForm(Model model) {
        log.info("2번 LoginController loginForm start");
        // 2. DB 연동(Mapper 인터페이스 사용, 다형성 구현)

        // 3. DB 연동 리턴값을 화면에 전달(view resolver, redirect, forward, responseBody: JSON 방식)
        return "login/loginForm"; // view resolber 방식
    }

    @PostMapping("/login")
    public void login(Member member, Model model) {
        log.info("2번 LoginController login start");
        log.info("2번 login userId = " + member.getUserId());
        log.info("2번 login userPw = " + member.getUserPw());

        member.setUserName("제우스");
        member.setEmail("zeus@zeus.com");
        model.addAttribute("user", member);
    }
}
