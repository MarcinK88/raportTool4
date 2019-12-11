package pl.marcin.raportTool4.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(Model model) {

        return "login";
    }

    @PostMapping("/login")
    public String postLogin(HttpServletRequest request, Principal principal) {

        HttpSession session = request.getSession();
        session.setAttribute("loggedUser", principal.getName());
        return "homepage";
    }

}
