package web.form.gds.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.form.gds.webapp.model.IncomeAndSpending2024;
import web.form.gds.webapp.model.PeriodConfirmation;

@Controller
public class MainController {

    @GetMapping("/")
    public String showConfirmation(Model model){
        model.addAttribute("PeriodConfirmation", new PeriodConfirmation());
        return "PeriodConfirmation";
    }
    @GetMapping("/income-and-spending")
    public String showForm(Model model){
        model.addAttribute("IncomeAndSpending2024", new IncomeAndSpending2024());
        return "IncomeAndSpending";
    }

}
