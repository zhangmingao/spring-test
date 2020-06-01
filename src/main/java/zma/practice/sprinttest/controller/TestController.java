package zma.practice.sprinttest.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

  @GetMapping("/ap")
  public String test(HttpServletRequest request) {
    ServletContext servletContext = request.getSession().getServletContext();
    ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    return "fuck you";
  }
}
