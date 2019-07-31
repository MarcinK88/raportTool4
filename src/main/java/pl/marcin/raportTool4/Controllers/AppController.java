package pl.marcin.raportTool4.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.marcin.raportTool4.Repositories.ConvertedRepository;
import pl.marcin.raportTool4.Import;
import pl.marcin.raportTool4.Models.Ticket;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class AppController {


    @Autowired
    private ConvertedRepository convertedRepository;

    @GetMapping("/")
    public String homepage(HttpServletRequest request, Model model) {

        return "homepage";
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







}
