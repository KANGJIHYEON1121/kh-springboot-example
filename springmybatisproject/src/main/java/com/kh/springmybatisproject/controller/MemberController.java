package com.kh.springmybatisproject.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springmybatisproject.domain.Member;
import com.kh.springmybatisproject.service.MemberDAOService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
@MapperScan(basePackages = "com.kh.springmybatisproject.mapper")
public class MemberController {
    @Autowired
    private MemberDAOService service;

    // 회원가입 화면 요청
    @GetMapping(value = "/register")
    public String registerForm(Member member, Model model) throws Exception {
        log.info("UserRegisterForm");
        return "member/register";
    }

    // 회원가입 처리 요청
    @PostMapping(value = "/register")
    public String register(Member member, Model model) throws Exception {
        service.insert(member);
        model.addAttribute("msg", "등록이 완료되었습니다.");
        return "member/success";
    }
}
