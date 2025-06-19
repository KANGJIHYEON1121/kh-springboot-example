package com.jeus.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jeus.demo.Member;

import lombok.extern.java.Log;

// 사용자 정보를 받는다 -> 해당되는 DB를 연동한다. -> 결과값을 해당되는 view로 넘겨준다.
@Log
@Controller
@RequestMapping("/member")
public class MemberController {
    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String registerForm() {
        log.info("registerForm");
        return "member/registerForm";
    }

    @PostMapping(value = "/register")
    public String register(Member member, String userId) {
        log.info("registerForm");
        log.info("userId = " + userId);
        log.info("member = " + member);
        log.info("member = " + member.getDateOfBirth());
        return "member/success";
    }

    @PostMapping(value = "/registerSelect")
    public String registerSelect(Member member) {
        log.info("registerSelect");
        for (int i = 0; i < member.getNationality().size(); i++) {
            log.info("nationality = " + member.getNationality().get(i));
        }
        return "member/success";
    }

    @PostMapping(value = "/registerBoard")
    public String registerBoard(Member member) {
        log.info("registerBoard");
        log.info("member.getUserId() = " + member.getUserId());
        log.info("member.getPassword() = " + member.getPassword());
        log.info("member.getDateOfBirth() = " + member.getDateOfBirth());
        log.info("member.getBoard().getBoardNo() = " + member.getBoard().getBoardNo());
        return "member/success";
    }

    @PostMapping(value = "/registerFileupload")
    public String registerFileupload(MultipartFile picture1, MultipartFile picture2)
            throws IllegalStateException, IOException {
        log.info("registerFileupload");
        if (picture1 != null) {
            log.info("serverUseName: " + picture1.getName());
            log.info("originalName: " + picture1.getOriginalFilename());
            log.info("size: " + picture1.getSize());
            log.info("contentType: " + picture1.getContentType());
            picture1.transferTo(new File("/Users/kjh/kh/springbootuploadfile/" + picture1.getOriginalFilename()));
        }
        if (picture2 != null) {
            log.info("serverUseName: " + picture2.getName());
            log.info("originalName: " + picture2.getOriginalFilename());
            log.info("size: " + picture2.getSize());
            log.info("contentType: " + picture2.getContentType());
            picture2.transferTo(new File("/Users/kjh/kh/springbootuploadfile/" + picture2.getOriginalFilename()));
        }
        return "member/success";
    }

    @GetMapping(value = "/registerAjaxFileUpForm")
    public String registerAjaxFileUpForm() {
        log.info("registerAjaxFileUpForm");
        return "member/registerAjaxFileUpForm"; // 뷰 파일명
    }

    @PostMapping(value = "/uploadAjax", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
        String originalFilename = file.getOriginalFilename();
        log.info("originalName: " + originalFilename);
        ResponseEntity<String> entity = new ResponseEntity<String>("UPLOADSUCCESS " + originalFilename, HttpStatus.OK);
        return entity;
    }

    @GetMapping(value = "/form")
    public String form() {
        log.info("form");
        return "member/form";
    }

    // RedirectAttributes rttr : 임시로 데이터를 세션에 저장, 다시 페이지 요청 세션 -> Request
    @PostMapping(value = "/submit")
    public String submit(@RequestParam String name, RedirectAttributes rttr, Model model)
            throws IllegalStateException, IOException {
        log.info("submit name " + name);

        rttr.addFlashAttribute("message", name + "님이 등록되었습니다.");
        model.addAttribute("name", name);
        return "redirect:/member/result";
    }

    @GetMapping(value = "/result")
    public String result() {
        log.info("result");
        return "member/result";
    }
}
