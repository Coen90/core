package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider; // scope가 request이기에 lifecycle 시작 전에 달라고해서 오류나옴
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
//        MyLogger myLogger = myLoggerProvider.getObject();
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + myLogger.getClass()); // CGLIB라는 바이트코드를 조작하는 라이브러리 사용하여 MyLogger를 상속받은 가짜 프록시 객체 생성

        myLogger.setRequestURL(requestURL);

        Thread.sleep(1000);

        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";

    }
}
