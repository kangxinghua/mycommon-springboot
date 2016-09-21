package org.mycommon.springboot.web.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.mycommon.springboot.utils.Global;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    /**
     * Go login.jsp
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login/login";
    }

    /**
     * Go login
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, RedirectAttributes rediect) {
        String username = request.getParameter(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM);
        String password = request.getParameter(FormAuthenticationFilter.DEFAULT_PASSWORD_PARAM);

        UsernamePasswordToken upt = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(upt);
        } catch (AuthenticationException e) {
            rediect.addFlashAttribute("errorText", "您的账号或密码输入错误!");
            return "redirect:" + Global.getLoginPath();
        }
        return "redirect:" + Global.getHomePath();
    }

    /**
     * Exit
     *
     * @return
     */
    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:" + Global.getHomePath();
    }
}
