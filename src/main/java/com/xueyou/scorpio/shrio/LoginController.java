package com.xueyou.scorpio.shrio;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public int login(@RequestBody LoginRequest request) {
        logger.info("username:{},password:{}", request.getUserName(), request.getPassword());
        String passwdMD5 = request.getUserName();
        String loginName = request.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, passwdMD5);
        int result = 0;
        token.setRememberMe(true);
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        } catch (AuthenticationException e) {
            result = 1;
            logger.error("login error", e);
        } catch (Exception e) {
            result = 1;
            logger.error("system error", e);
        }
        return result;
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.POST})
    public int logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return 0;
    }
}
