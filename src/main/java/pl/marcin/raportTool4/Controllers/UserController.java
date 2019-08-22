package pl.marcin.raportTool4.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.marcin.raportTool4.Models.Users;
import pl.marcin.raportTool4.Repositories.UsersRepository;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/changepwd")
    public String changePassword() {

        return "changepwd";
    }

    @PostMapping("/changepwd")
    public String changePasswordPost(Model model, Principal principal, @RequestParam String oldpwd, @RequestParam String newpwd) {

        String response = "";
        Users user = usersRepository.findByUsername(principal.getName());
        if (BCrypt.checkpw(oldpwd, user.getPassword())) {
            user.setPassword(BCrypt.hashpw(newpwd,BCrypt.gensalt()));
            usersRepository.save(user);
            response = "password changed";
        } else {
            response = "wrong password";
        }
        model.addAttribute("response", response);

        return "/changepwd";
    }

    @GetMapping("/admin/editusers")
    public String editUsers(Model model) {

        List<Users> users = usersRepository.findAll();

        model.addAttribute("users", users);

        return "editUsers";
    }

    @GetMapping("/admin/editusers/{username}")
    public String editUser(@PathVariable String username, Model model){

        Users userToEdit = usersRepository.findByUsername(username);
        model.addAttribute("user", userToEdit);
        List<String> enabled = new ArrayList<>();
        enabled.add("true");
        enabled.add("false");
        List<Integer> role = new ArrayList<>();
        role.add(1);
        role.add(2);
        model.addAttribute("enabled", enabled);
        model.addAttribute("role", role);
        model.addAttribute("text", userToEdit.toString());
        return "edituserform";
    }

    @PostMapping("/admin/editusers/{username}")
    public String editUser(@ModelAttribute Users user){

        Users userToCompare = usersRepository.findByUsername(user.getUsername());

        if(!userToCompare.getPassword().equals(user.getPassword())) {
            user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
        }

        usersRepository.save(user);

        return "redirect:/admin/editusers";

    }

    @GetMapping("/newuser")
    public String addNewUser(Model model) {

        Users user = new Users();
        List<String> enabled = Arrays.asList("false", "true");
        model.addAttribute("user", user);
        model.addAttribute("enabled", enabled);
        return "adduserform";
    }

    @PostMapping("/newuser")
    public String addNewUserPost(@ModelAttribute Users user){

        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
        usersRepository.save(user);
        return "redirect:/admin/editusers";
    }

    @GetMapping("/admin/confirmdelete/{username}")
    public String confirmDelete(@PathVariable String username, Model model) {
        model.addAttribute("username", username);

        return "confirmdelete";
    }

    @GetMapping("/admin/deleteuser/{username}")
    public String deleteUser(@PathVariable String username){

        Users userToDelete = usersRepository.findByUsername(username);
        usersRepository.delete(userToDelete);
        return "redirect:/admin/editusers";
    }
}
