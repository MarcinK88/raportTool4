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
        return "login";
    }

//    @PostMapping("/login")
//    public String postLogin(@ModelAttribute User user, HttpServletRequest request) {
//
//
//        User user1 = userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
//        if(user1 != null) {
//
//            HttpSession session = request.getSession();
//            session.setAttribute("loggedUser", user1.getLogin());
//
//            return "redirect:/";
//        } else {
//            return "wrongpassword";
//        }
//    }

//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request) {
//
//        HttpSession session = request.getSession();
//        session.removeAttribute("loggedUser");
//
//        return "redirect:/";
//    }


}
