package pl.marcin.raportTool4;

import org.apache.poi.xddf.usermodel.PresetColor;
import org.apache.poi.xddf.usermodel.XDDFColor;
import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.apache.poi.xddf.usermodel.XDDFSolidFillProperties;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String charttestPost(@ModelAttribute TableWriter tableWriter) throws IOException, ParseException {

        tableWriter.createOpenedPerMonth(convertedRepository);
        tableWriter.createRequestPerBa(convertedRepository);
        tableWriter.createRequestPerRegion(convertedRepository);
        tableWriter.createRequestPerCategory(convertedRepository);
        tableWriter.createKpi1(convertedRepository);
        tableWriter.createKpi2(convertedRepository);
        tableWriter.createKpi3(convertedRepository);
        tableWriter.saveToFile();

        return "charttest";
    }


}
