package com.kh.springbootinterceptor.common.interceptor;

import java.lang.reflect.Method;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static final String USER_INFO = "userInfo";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("1번 preHandle");
        String requestURI = request.getRequestURI();
        // requestURL : URL => http://128.0.0:80/...
        log.info("1번 requestURI : " + requestURI);

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method methodObj = handlerMethod.getMethod();

        // Bean: com.kh.controller.loginController@13ed2e22
        log.info("1번 Bean: " + handlerMethod.getBean());

        // Method: public void com.kh.contrroller.Logincontroller.login()
        log.info("1번 Method: " + methodObj);

        // 세션값을 가져온다
        HttpSession session = request.getSession();
        // 세션값에 로그인해서 성공한 사용자 정보가 들어있다, 공통으로 관리 할 정보
        if (session.getAttribute(USER_INFO) != null) {
            // 세션값에 사용자 정보를 삭제한다.
            session.removeAttribute(USER_INFO);
            log.info("1번 session 사용자 정보 삭제완료");
            // response.sendRedirect("/");
            // return false;
        }
        return true;
    }

    @Override
    // controller 종료할때 진행
    // ModelAndView : 2가지 기능 (Model, View Resolver 정보를 가지고 있는 객체)
    // ex) return "login/register"
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        log.info("3번 postHandle");

        String requestURL = request.getRequestURI();
        log.info("3번 requestURL : " + requestURL);

        HandlerMethod method = (HandlerMethod) handler;
        Method methodObj = method.getMethod();
        log.info("3번 Bean: " + method.getBean());
        log.info("3번 Method: " + methodObj);

        // session 값을 가져온다.
        HttpSession session = request.getSession();
        // ModelMap => Model 같음
        ModelMap modelMap = modelAndView.getModelMap();
        // controller 에서 ModelAndView에 담은 user 객체를 가져온다.
        Object member = modelMap.get("user");

        if (member != null) {
            log.info("3번 member != null");
            session.setAttribute("userInfo", member);
            response.sendRedirect("/");
        }
    }

    // view resolver 실행하기 전
    // @Override
    // public void afterCompletion(HttpServletRequest request, HttpServletResponse
    // response, Object handler, Exception ex)
    // throws Exception {
    // log.info("4번 afterCompletion");
    // HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    // }

}
