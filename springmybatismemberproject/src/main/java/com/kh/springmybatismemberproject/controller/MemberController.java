package com.kh.springmybatismemberproject.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springmybatismemberproject.domain.MybatisMember;
import com.kh.springmybatismemberproject.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
// 공통 주소 /member 설정
@RequestMapping("/member")
@MapperScan(basePackages = "com.kh.springmybatismemberproject.mapper")
public class MemberController {
    // DB 연동
    @Autowired
    MemberService memberService;

    // 정보 입력 화면요청
    @GetMapping("/registerForm")
    public String registerForm(MybatisMember member, Model model) throws Exception {
        log.info("registerForm");
        model.addAttribute("member", member);
        return "member/register";
    }

    // 정보 내용 DB입력
    @PostMapping("/register")
    public String register(MybatisMember member, Model model) throws Exception {
        log.info("register");
        memberService.insert(member);
        model.addAttribute("msg", "등록이 완료되었습니다.");
        return "member/success";
    }

    // 게시판 내용 전체 출력
    @GetMapping("/list")
    public void list(Model model) throws Exception {
        log.info("list");
        model.addAttribute("list", memberService.selectAll());
    }

    // 게시판 출력(No)
    @RequestMapping("/read")
    public String read(MybatisMember member, Model model) throws Exception {
        log.info("read");
        model.addAttribute("member", memberService.select(member));
        return "member/read";
    }

    // 게시판 삭제
    @PostMapping("/remove")
    public String remove(MybatisMember member, Model model) throws Exception {
        log.info("remove");
        memberService.delete(member);
        model.addAttribute("msg", "삭제가 완료되었습니다.");
        return "member/success";
    }

    // 게시판 수정 화면 요청
    @GetMapping("/modify")
    public String modifyForm(MybatisMember member, Model model) throws Exception {
        log.info("modifyForm");
        model.addAttribute("member", memberService.select(member));
        return "member/modify";
    }

    // 게시판 수정내용 DB 저장
    @PostMapping("/modify")
    public String modify(MybatisMember member, Model model) throws Exception {
        log.info("modify");
        memberService.update(member);
        model.addAttribute("msg", "수정 완료되었습니다.");
        return "member/success";
    }
}
