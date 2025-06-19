package com.example.devproject.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// 사용자 정보(http://127.0.0.1:8080/home)를 받는다. 해당되는 db 연동한다. 뷰를 불러준다.
@Log
@Controller
public class HomeController {

    // http://127.0.0.1:8080/home get방식
    // Model,(Request, Session, Application : 생명주기)
    // @PostMapping(value = "/home")
    // public String postMethodName(@RequestBody String entity) {
    // // TODO: process POST request

    // return entity;
    // }

    @RequestMapping(value = "/home")
    public String home(Locale locale, Model model) {
        log.info("여기는 HomeController home() 입니다." + locale.toString());
        log.info("여기는 HomeController home() 입니다." + model.toString());
        // db연동 하지 않는다.
        // view를 불러준다.(~ : view Resolver)
        Date date = new Date();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);
        String formatDate = df.format(date);
        // model 사용(Request)
        model.addAttribute("serverTime", formatDate);
        return "home";
    }

    @RequestMapping(value = "/sub")
    public String sub() {

        return "sub";
    }

}
