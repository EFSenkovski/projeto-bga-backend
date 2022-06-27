package br.com.eduardo.jobapi.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tokens")
public class TokenController {

    @DeleteMapping("/revoke")
    public void revoke(HttpServletRequest req, HttpServletResponse resp){
        Cookie c = new Cookie("refreshToken", null);
        c.setHttpOnly(true);
        c.setSecure(false);
        c.setPath(req.getContextPath() + "/oauth/token");
        c.setMaxAge(0);

        resp.addCookie(c);
        resp.setStatus(HttpStatus.NO_CONTENT.value());
    }
    
}
