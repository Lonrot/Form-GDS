package web.form.gds.webapp.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import web.form.gds.webapp.model.IncomeAndSpending2024;

@Controller
public class IncomeAndSpendingController implements WebMvcConfigurer {


    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("IncomeAndSpending2024") IncomeAndSpending2024 incomeAndSpending2024, BindingResult result, Model model) {
        model.addAttribute("IncomeAndSpending2024", incomeAndSpending2024);

        if (result.hasErrors()) {
            return "IncomeAndSpending";
        }

        model.addAttribute("message", "Income: " + incomeAndSpending2024.getIncome() + " Spending: " + incomeAndSpending2024.getSpending());
        System.out.println(incomeAndSpending2024);
        return "result";
    }

}