package web.form.gds.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.form.gds.webapp.model.PeriodConfirmation;

import java.util.logging.Logger;

@Controller
public class PeriodConfirmationController {

    @PostMapping("/periodConfirmation/next")
    public String continueToForm(){
        return "redirect:/income-and-spending";
    }
    @GetMapping("/period-confirmation/edit")
    public String editPeriod(Model model){
        Logger.getGlobal().info("Edit period");
        model.addAttribute("PeriodConfirmation", new PeriodConfirmation());
        return "PeriodConfirmation";
    }
}