package com.jeus.demo.controller;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeus.demo.Board;

import lombok.extern.java.Log;

// 사용자 정보를 받는다 -> 해당되는 DB를 연동한다. -> 결과값을 해당되는 view로 넘겨준다.
@Log
@Controller
public class HomeController {
    @Autowired
    private MessageSource messageSource;

    // http://127.0.0.1:8800/home get 방식
    // Model, (Request, Response, Session, Application : 생명주기)
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Locale Locale, Model model) {
        log.info("여기는 HomeController home() 입니다." + Locale.toString());
        log.info("여기는 HomeController home() 입니다." + model.toString());
        // 디비연동하지 않는다.
        // 뷰를 불러준다. (~ : view Resolver)
        Date data = new Date();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale);
        String fomatDate = df.format(data);
        // 모델(Request)
        model.addAttribute("serverTime", fomatDate);

        return "home01";
    }

    @RequestMapping(value = "/sub", method = RequestMethod.GET)
    public String sub(Model model) {
        Board board = new Board(10, "kdj", "zeus", "김동진", null);
        model.addAttribute("board", board);
        return "home02";
    }

    @RequestMapping(value = "/home03", method = RequestMethod.GET)
    public String home03() {
        return "home03";
    }

    @RequestMapping(value = "/home04", method = RequestMethod.GET)
    public String home04(Locale Locale, Model model) {

        // 문자열배열, ArrayList => DB, VO
        String[] name = { "홍길동", "제우스", "톰캣" };
        List<String> nameList = Arrays.asList("홍길동", "제우스", "톰캣");
        model.addAttribute("name", name);
        model.addAttribute("nameList", nameList);

        return "home04";
    }

    @RequestMapping(value = "/home05", method = RequestMethod.GET)
    public String home05(Model model) {
        // HashMap 만들어서(DB, 사용자입력) 화면으로 출력. id, pwd, email, name, date
        Map memberMap = new HashMap<>();
        memberMap.put("id", "test123");
        memberMap.put("pwd", "123456");
        memberMap.put("email", "test123@naver.com");
        memberMap.put("name", "hgd");
        memberMap.put("date", new Date());
        model.addAttribute("memberMap", memberMap);
        return "home05";
    }

    @RequestMapping(value = "/home0303", method = RequestMethod.GET)
    public String home0303(Model model) {
        Board board = new Board();
        board.setTitle("");
        model.addAttribute("board", board);
        return "home0303";
    }

    @RequestMapping(value = "/home0202", method = RequestMethod.GET)
    public String home0202(Model model) {
        Board board = new Board();
        board.setTitle("spring boot");
        model.addAttribute("board", board);
        return "home0202";
    }

    // WEB-INF/VIEWS/home0901.jsp get (함수명은 오버로딩 위배조건 안되면 가능)
    @RequestMapping(value = "home0901", method = RequestMethod.GET)
    public String home0901() {
        return "home0901";
    }

    // WEB-INF/VIEWS/boardjstl/search.jsp, get, parmeter value, model 전달해서 화면에 출력해달라
    @RequestMapping("/boardjstl/search")
    public void search(Board board, String title, Model model) {
        log.info("search keyword = " + board);
        log.info("search keyword title = " + title);
        model.addAttribute("board", board);
    }

    // @RequestMapping("/boardjstl/search")
    // public void search(Board board, int title, Model model) {
    // log.info("search keyword = " + board);
    // log.info("search keyword title = " + (title + 100));
    // model.addAttribute("board", board);
    // }

    @RequestMapping("/boardjstl/list")
    public void list() {
        log.info("/boardjstl/list");
    }

    @RequestMapping("/home1001")
    public void home1001() {
        log.info("/home1001");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home1(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime",
                formattedDate);
        return "home"; // 뷰 파일명
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String home2(Locale locale, Model model) {
        log.info("환영합니다. 클라이언트 지역은 " + locale + "이다.");
        String[] args = { "Lee" };
        // 스프링 프레임워크로부터 MessageSource를 주입 받은 다음 getMessage 메서드를 호출한다.
        String message = messageSource.getMessage("welcome.message", args, Locale.KOREAN);
        String message2 = messageSource.getMessage("welcome.message", args, Locale.ENGLISH);
        log.info("Welcome message : " + message);
        log.info("Welcome message2 : " + message2);
        return "home";
    }
}
