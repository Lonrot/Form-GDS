package web.form.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.core.FormFlowService;
import web.form.model.Form;
import web.form.model.PageName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/countries")
public class CountriesController {
    // List of all available countries
    private static final List<String> ALL_COUNTRIES = Arrays.asList(
            "United Kingdom", "France", "Germany", "Spain", "Italy",
            "Netherlands", "Belgium", "Portugal", "Sweden", "Denmark",
            "Norway", "Finland", "Greece", "Switzerland", "Austria"
    );

    private final FormFlowService formFlowService;

    @Autowired
    public CountriesController(FormFlowService formFlowService) {
        this.formFlowService = formFlowService;
    }

    @GetMapping
    public String showCountrySelection(@RequestParam("ar") String year, Model model) {

            model.addAttribute("CountrySelection2025", new CountrySelectionForm());
            model.addAttribute("allCountries", ALL_COUNTRIES);

            model.addAttribute("ARCycle", "error");
        return "2025/country-selection";
    }

    @PostMapping("/submit")
    public String processSelection(@Valid @ModelAttribute("CountrySelection2025") CountrySelectionForm form,
                                   BindingResult result, Model model, @RequestParam("ar") String year) {

        if (result.hasErrors()) {
            model.addAttribute("CountrySelection2025", form);
            model.addAttribute("allCountries", ALL_COUNTRIES);
            return "2025/country-selection";
        }

        String nextStep = formFlowService.getNextStep(form);
        return "redirect:/" + nextStep + "?ar=" + year;
    }

    @Getter @Setter
    public static class CountrySelectionForm implements Form {
        private List<String> selectedCountries = new ArrayList<>();

        @Override
        public PageName getPageID() {
            return PageName.COUNTRY_SELECTION;
        }
    }
}


