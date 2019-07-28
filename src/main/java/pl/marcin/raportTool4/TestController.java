package pl.marcin.raportTool4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/test2")
    @ResponseBody
    public String displayTest(@RequestParam int a, @RequestParam int b) {

        return testService.call(a,b).toString();

//        return "test";
    }

}
