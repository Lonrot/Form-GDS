package web.form.controller.contracts;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.core.FormFlowService;
import web.form.model.contracts.Contracts2025;

@Controller
@RequestMapping("/contracts")
public class ContractsController {
    private final FormFlowService formFlowService;

    @Autowired
    public ContractsController(FormFlowService formFlowService) {
        this.formFlowService = formFlowService;
    }

    @GetMapping
    public String showForm(@RequestParam("ar") String year, Model model) {
        switch (year) {
            case "2025" -> model.addAttribute("Contracts2025", new Contracts2025());
            case "2024" -> model.addAttribute("Contracts2024", "2024");
            default -> model.addAttribute("ARCycle", "error");
        }
        return year + "/contracts";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("Contracts2025") Contracts2025 contracts2025,
                             BindingResult result, Model model, @RequestParam("ar") String year) {

        if (result.hasErrors()) {
            model.addAttribute("Contracts2025", contracts2025);
            return year + "/contracts";
        }

       return "2025/" + formFlowService.getNextStep(contracts2025);


    }

}


