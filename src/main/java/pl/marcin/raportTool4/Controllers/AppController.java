package pl.marcin.raportTool4.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.marcin.raportTool4.Models.OpenedPerMonth;
import pl.marcin.raportTool4.Models.Users;
import pl.marcin.raportTool4.Repositories.ConvertedRepository;
import pl.marcin.raportTool4.Repositories.UsersRepository;
import pl.marcin.raportTool4.Services.Import;
import pl.marcin.raportTool4.Models.Ticket;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {


    @Autowired
    private ConvertedRepository convertedRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/")
    public String homepage() {

        return "homepage";
    }

    @GetMapping("/403")
    public String errorPage(){
        return "403";
    }
    @GetMapping("/bootstrap")
    public String testpage(Model model) {


        OpenedPerMonth openedPerMonth = new OpenedPerMonth(2019,"May",convertedRepository);

        List<String> sortedMonths = openedPerMonth.getSortedMonths();
        List<String> types = openedPerMonth.getTypes();

        model.addAttribute("months", sortedMonths);
        model.addAttribute("types", types);
        model.addAttribute("dnsData", openedPerMonth.getDnsDatas());
        model.addAttribute("sslData", openedPerMonth.getSslDatas());
        model.addAttribute("ipData", openedPerMonth.getIpMgmtDatas());
        model.addAttribute("domainData", openedPerMonth.getDnsDatas());
        model.addAttribute("otherData", openedPerMonth.getOtherDatas());
        model.addAttribute("domainMgmtData", openedPerMonth.getDomainMgmtDatas());
        model.addAttribute("ipdata", openedPerMonth.getIpMgmtDatas());
        model.addAttribute("ssldata", openedPerMonth.getSslDatas());
        model.addAttribute("dnsdata", openedPerMonth.getDnsDatas());

        return "bootstrap";
    }

    @GetMapping("/importlist")
    public String importFile(Model model){

        return "importfile";
    }
    @PostMapping("/importlist")
    public String importFilePost(@RequestParam("file")MultipartFile file, Model model) throws IOException {

        List<Ticket> tickets = Import.createTickets(file, convertedRepository);
        model.addAttribute("tickets", tickets);

        return "ticketlist2";

    }

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
        model.addAttribute("user", user);

        return "adduserform";
    }

    @PostMapping("/newuser")
    public String addNewUserPost(@ModelAttribute Users user){

        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
        usersRepository.save(user);
        return "redirect:/admin/editusers";
    }

}
