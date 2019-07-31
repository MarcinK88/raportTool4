package pl.marcin.raportTool4.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.marcin.raportTool4.Models.User;
import pl.marcin.raportTool4.Repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String getLogin(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute User user, HttpServletRequest request) {


        User user1 = userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
        if(user1 != null) {

            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", user1.getLogin());

            return "redirect:/";
        } else {
            return "wrongpassword";
        }


    }

}
