package web.form.model;

import lombok.Data;

import java.util.List;

@Data
public class CountrySelectionForm {
    private List<String> allCountries;
    private List<String> selectedCountries;
}
