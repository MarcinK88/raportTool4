package pl.marcin.raportTool4.Controllers;

import com.mysql.cj.xdevapi.JsonArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.marcin.raportTool4.Models.OpenedPerMonth;
import pl.marcin.raportTool4.Repositories.ConvertedRepository;
import pl.marcin.raportTool4.Import;
import pl.marcin.raportTool4.Models.Ticket;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AppController {


    @Autowired
    private ConvertedRepository convertedRepository;

    @GetMapping("/")
    public String homepage(HttpServletRequest request, Model model) {

        return "homepage";
    }

    @GetMapping("/bootstrap")
    public String testpage(Model model) {

//        List<String> months = Arrays.asList("january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december");
//        JSONObject jsonObject = JSONObject.fromObject( months );

        OpenedPerMonth openedPerMonth = new OpenedPerMonth(2019,"May",convertedRepository);

//        for(int i = 0; i < openedPerMonth.getMonths().size(); i++) {
//            int j = 0;
//            if ((i + openedPerMonth.getSelectedMonthIndex()) < openedPerMonth.getMonths().size()) {
//                System.out.println(i + openedPerMonth.getSelectedMonthIndex() + 1);
//                openedPerMonth.addDnsData(convertedRepository.countByRequestTypeAndOpenDateStartsWith("DNS",
//                        2018,i + openedPerMonth.getSelectedMonthIndex() + 1));
//                openedPerMonth.addSslData(convertedRepository.countByRequestTypeAndOpenDateStartsWith("SSL Certificate",
//                        2018,i + openedPerMonth.getSelectedMonthIndex() + 1));
//                openedPerMonth.addIpMgmtData(convertedRepository.countByRequestTypeAndOpenDateStartsWith("IP Mgmt",
//                        2018,i + openedPerMonth.getSelectedMonthIndex() + 1));
//                openedPerMonth.addDomainMgmtData(convertedRepository.countByRequestTypeAndOpenDateStartsWith("Domain mgmt",
//                        2018,i + openedPerMonth.getSelectedMonthIndex() + 1));
//                openedPerMonth.addOtherData(convertedRepository.countByRequestTypeAndOpenDateStartsWith("Other",
//                        2018,i + openedPerMonth.getSelectedMonthIndex() + 1));
//            }
//            else {
//                openedPerMonth.addDnsData(convertedRepository.countByRequestTypeAndOpenDateStartsWith("DNS",
//                        2019,j + 1));
//                openedPerMonth.addSslData(convertedRepository.countByRequestTypeAndOpenDateStartsWith("SSL Certificate",
//                        2019,j + 1));
//                openedPerMonth.addIpMgmtData(convertedRepository.countByRequestTypeAndOpenDateStartsWith("IP Mgmt",
//                        2019,j + 1));
//                openedPerMonth.addDomainMgmtData(convertedRepository.countByRequestTypeAndOpenDateStartsWith("Domain mgmt",
//                        2019,j + 1));
//                openedPerMonth.addOtherData(convertedRepository.countByRequestTypeAndOpenDateStartsWith("Other",
//                        2019,j + 1));
//                j++;
//            }
//
//        }




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







}
