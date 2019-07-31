package pl.marcin.raportTool4.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.marcin.raportTool4.Repositories.ConvertedRepository;
import pl.marcin.raportTool4.TableWriter;

import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.text.ParseException;

@Controller
public class ChartController {

    @Autowired
    private ConvertedRepository convertedRepository;

    @GetMapping("/charts")
    public String charts() {

        return "charts";
    }

    @GetMapping("/charttest")
    public String charttestGet(Model model) {

        TableWriter tableWriter = new TableWriter();

        model.addAttribute("years", tableWriter.getYears());
        model.addAttribute("months", tableWriter.getMonths());

        model.addAttribute(tableWriter);
        return "charttest";
    }

    @PostMapping("/charttest")
    public String charttestPost(@ModelAttribute TableWriter tableWriter, HttpServletResponse response) throws IOException, ParseException, XMLStreamException {

        tableWriter.createOpenedPerMonth(convertedRepository);
        tableWriter.createRequestPerBa(convertedRepository);
        tableWriter.createRequestPerRegion(convertedRepository);
        tableWriter.createRequestPerCategory(convertedRepository);
        tableWriter.createKpi1(convertedRepository);
        tableWriter.createKpi2(convertedRepository);
        tableWriter.createKpi3(convertedRepository);
        tableWriter.saveToFile(response);

        return "charttest";
    }


}
