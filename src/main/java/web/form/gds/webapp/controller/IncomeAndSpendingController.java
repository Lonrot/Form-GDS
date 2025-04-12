package web.form.gds.webapp.controller;

import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import web.form.gds.webapp.model.BaseIncomeAndSpending;
import web.form.gds.webapp.model.IncomeAndSpending2024;

@Controller
public class IncomeAndSpendingController implements WebMvcConfigurer {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/income-and-spending")
    public String showForm(Model model){
        model.addAttribute("IncomeAndSpending2024", new IncomeAndSpending2024());
        return "IncomeAndSpending";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid IncomeAndSpending2024 incomeAndSpending2024,
            BindingResult bindingResult,
            Model model) {

        model.addAttribute("IncomeAndSpending2024", incomeAndSpending2024);

        if (bindingResult.hasErrors()) {
            return "IncomeAndSpending";
        }

        model.addAttribute("message", "Income: " + incomeAndSpending2024.getIncome() +
                " Spending: " + incomeAndSpending2024.getSpending());
        System.out.println(incomeAndSpending2024);
        return "result";
    }
}