package web.form.controller.incomeandspending;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.core.FormFlowService;
import web.core.factory.IncomeAndSpendingServiceFactory;
import web.form.model.incomeandspending.IncomeAndSpending2025;

@Controller
@RequestMapping("/income-and-spending")
public class IncomeSpendingController {


    private final FormFlowService formFlowService;
    private final IncomeAndSpendingServiceFactory factory;


    @Autowired
    public IncomeSpendingController(FormFlowService formFlowService, IncomeAndSpendingServiceFactory factory) {
        this.formFlowService = formFlowService;
        this.factory = factory;
    }

    @GetMapping
    public String showForm(@RequestParam("ar") String year, Model model) {

        switch (year) {
            case "2025" -> model.addAttribute("IncomeAndSpending2025", new IncomeAndSpending2025());
            case "2024" -> model.addAttribute("ARCycle", "2024");
            default -> model.addAttribute("ARCycle", "error");
        }
        return year + "/income-and-spending";
    }



    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("IncomeAndSpending2025") IncomeAndSpending2025 incomeAndSpending2025,
                             BindingResult result, Model model, @RequestParam("ar") String year
    ) {

        if (result.hasErrors()) {
            model.addAttribute("IncomeAndSpending2025", incomeAndSpending2025);
            return "2025/income-and-spending" ;
        }

        System.out.println(incomeAndSpending2025.getIncome() + " " + incomeAndSpending2025.getSpending());


        String nextStep = formFlowService.getNextStep(incomeAndSpending2025);
        return "redirect:/" + nextStep + "?ar=" + year;



    }

}
