package pl.marcin.raportTool4.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.marcin.raportTool4.Models.MonthDatas;
import pl.marcin.raportTool4.Models.OpenedPerMonth;
import pl.marcin.raportTool4.Repositories.ConvertedRepository;
import pl.marcin.raportTool4.Services.TableWriter;

import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
public class ChartController {

    @Autowired
    private ConvertedRepository convertedRepository;

    @GetMapping("/selectmonth")
    public String monthlyReportSelectMonth(Model model) {

        TableWriter tableWriter = new TableWriter();

        model.addAttribute("years", tableWriter.getYears());
        model.addAttribute("months", tableWriter.getMonths());


        model.addAttribute(tableWriter);
        return "selectmonth";
    }

    @PostMapping("/selectmonth")
    public String monthlyReportSelectMonthPost(@ModelAttribute TableWriter tableWriter, Model model) throws IOException, ParseException, XMLStreamException {

        OpenedPerMonth openedPerMonth = new OpenedPerMonth(tableWriter.getSelectedYear(), tableWriter.getSelectedMonth(), convertedRepository, "all");

        List<String> sortedMonths = openedPerMonth.getSortedMonths();
        List<String> types = openedPerMonth.getTypes();

        model.addAttribute("months", sortedMonths);
        model.addAttribute("types", types);
        model.addAttribute("dnsData", openedPerMonth.getDnsDatas());
        model.addAttribute("sslData", openedPerMonth.getSslDatas());
        model.addAttribute("ipData", openedPerMonth.getIpMgmtDatas());
        model.addAttribute("domainMgmtData", openedPerMonth.getDomainMgmtDatas());
        model.addAttribute("otherData", openedPerMonth.getOtherDatas());

        model.addAttribute("selectedMonth", tableWriter.getSelectedMonth());
        model.addAttribute("selectedYear", tableWriter.getSelectedYear());

        MonthDatas monthDatas = new MonthDatas(tableWriter.getSelectedYear(), tableWriter.getSelectedMonth(), convertedRepository, "all");
        model.addAttribute("sortedThreeMonths", monthDatas.getSortedMonths());
        model.addAttribute("ba", monthDatas.getBas());
        model.addAttribute("coDatas", monthDatas.getCoDatas());
        model.addAttribute("isDatas", monthDatas.getIsDatas());
        model.addAttribute("mxDatas", monthDatas.getMxDatas());
        model.addAttribute("seDatas", monthDatas.getSeDatas());
        model.addAttribute("etDatas", monthDatas.getEtDatas());
        model.addAttribute("ctDatas", monthDatas.getCtDatas());
        model.addAttribute("apacDatas", monthDatas.getApacDatas());
        model.addAttribute("emeaDatas", monthDatas.getEmeaDatas());
        model.addAttribute("latamDatas", monthDatas.getLatamDatas());
        model.addAttribute("naDatas", monthDatas.getNaDatas());
        model.addAttribute("totalDnsDatas", monthDatas.getTotalDnsDatas());
        model.addAttribute("totalSslDatas", monthDatas.getTotalSslDatas());
        model.addAttribute("totalIpDatas", monthDatas.getTotalIpDatas());
        model.addAttribute("totalDomainDatas", monthDatas.getTotalDomainDatas());
        model.addAttribute("totalOtherDatas", monthDatas.getTotalOtherDatas());

        model.addAttribute("kpi1", monthDatas.getKpi1());
        model.addAttribute("kpi2", monthDatas.getKpi2());

        model.addAttribute("kpi3DnsDatas", monthDatas.getKpi3DnsDatas());
        model.addAttribute("kpi3SslDatas", monthDatas.getKpi3SslDatas());
        model.addAttribute("kpi3IpDatas", monthDatas.getKpi3IpDatas());
        model.addAttribute("kpi3DomainDatas", monthDatas.getKpi3DomainDatas());
        model.addAttribute("kpi3OtherDatas", monthDatas.getKpi3OtherDatas());

        return "monthlyreport";
    }

    @GetMapping("/tablewriter/{selectedmonth}/{selectedyear}")
    public String tablewriter(HttpServletResponse response, @PathVariable String selectedmonth, @PathVariable Integer selectedyear) throws ParseException, IOException, XMLStreamException {

        TableWriter tableWriter = new TableWriter();
        tableWriter.setSelectedMonth(selectedmonth);
        tableWriter.setSelectedYear(selectedyear);
        tableWriter.createOpenedPerMonth(convertedRepository);
        tableWriter.createRequestPerBa(convertedRepository);
        tableWriter.createRequestPerRegion(convertedRepository);
        tableWriter.createRequestPerCategory(convertedRepository);
        tableWriter.createKpi1(convertedRepository);
        tableWriter.createKpi2(convertedRepository);
        tableWriter.createKpi3(convertedRepository);
        tableWriter.saveToFile(response);

        return "selectmonth";

    }

    @GetMapping("/ba")
    public String chooseBaAndDate(Model model) {

        TableWriter tableWriter = new TableWriter();

        model.addAttribute("years", tableWriter.getYears());
        model.addAttribute("months", tableWriter.getMonths());
        model.addAttribute("ba", tableWriter.getBa());

        model.addAttribute(tableWriter);

        return "baSelectMonth";
    }

    @PostMapping("/ba")
    public String baReport(@ModelAttribute TableWriter tableWriter, Model model) {
        OpenedPerMonth openedPerMonth = new OpenedPerMonth(tableWriter.getSelectedYear(), tableWriter.getSelectedMonth(), convertedRepository, tableWriter.getSelectedBa());
        MonthDatas monthDatas = new MonthDatas(tableWriter.getSelectedYear(), tableWriter.getSelectedMonth(), convertedRepository, tableWriter.getSelectedBa());

        List<String> sortedMonths = openedPerMonth.getSortedMonths();
        List<String> types = openedPerMonth.getTypes();

        model.addAttribute("selectedBa", tableWriter.getSelectedBa());
        model.addAttribute("selectedMonth", tableWriter.getSelectedMonth());
        model.addAttribute("selectedYear", tableWriter.getSelectedYear());

        model.addAttribute("months", sortedMonths);
        model.addAttribute("types", types);
        model.addAttribute("dnsData", openedPerMonth.getDnsDatas());
        model.addAttribute("sslData", openedPerMonth.getSslDatas());
        model.addAttribute("ipData", openedPerMonth.getIpMgmtDatas());
        model.addAttribute("domainMgmtData", openedPerMonth.getDomainMgmtDatas());
        model.addAttribute("otherData", openedPerMonth.getOtherDatas());

        model.addAttribute("totalDnsDatas", monthDatas.getTotalDnsDatas());
        model.addAttribute("totalSslDatas", monthDatas.getTotalSslDatas());
        model.addAttribute("totalIpDatas", monthDatas.getTotalIpDatas());
        model.addAttribute("totalDomainDatas", monthDatas.getTotalDomainDatas());
        model.addAttribute("totalOtherDatas", monthDatas.getTotalOtherDatas());


        return "baReport";
    }


}
