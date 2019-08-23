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



    @GetMapping("/")
    public String homepage() {

        return "homepage";
    }

    @GetMapping("/403")
    public String errorPage(){
        return "403";
    }


    @GetMapping("/importlist")
    public String importFile(Model model){

        return "importfile";
    }
    @PostMapping("/importlist")
    public String importFilePost(@RequestParam("file")MultipartFile file, Model model) throws IOException {

        List<Ticket> tickets = Import.createTickets(file, convertedRepository);

        return "redirect:/alltickets";

    }



}
