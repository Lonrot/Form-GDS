package web.form.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.form.model.incomeandspending.IncomeAndSpending2025;

@Controller
@RequestMapping("/income-and-spending")
public class IncomeSpendingController {

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("IncomeAndSpending2025") IncomeAndSpending2025 incomeAndSpending2025, BindingResult result, Model model) {
        model.addAttribute("IncomeAndSpending2024", incomeAndSpending2025);

        if (result.hasErrors()) {
            return "2025/income-and-spending";
        }
        return "index";
    }
}
