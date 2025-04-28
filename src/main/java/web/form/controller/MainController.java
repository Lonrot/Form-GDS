package web.form.controller;


import integration.service.ServiceIntegration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.form.model.initialpage.AnnualReturn;
import web.form.model.initialpage.AnnualReturnArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Controller
public class MainController {

    private final ServiceIntegration serviceIntegration;

    public MainController(ServiceIntegration serviceIntegration) {
        this.serviceIntegration = serviceIntegration;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/select-ar")
    public String selectAR(Model model) {
        AnnualReturnArray annualReturnArray = serviceIntegration.getAvailableARs("256653");
        List<AnnualReturn> annualReturnList = Arrays.asList(annualReturnArray.annualReturns());
        Collections.reverse(annualReturnList);

        annualReturnList.stream()
                .filter(AR -> !AR.getCompleted())
                .findFirst()
                .ifPresent(AR -> AR.setNextToComplete(true));

        Collections.reverse(annualReturnList);

        model.addAttribute("annualReturns", annualReturnList);
        return "selectAR";
    }

}

