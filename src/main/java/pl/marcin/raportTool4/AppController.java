package pl.marcin.raportTool4;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
