package web.form.model;

import lombok.Getter;

@Getter
public enum PageName {
    SELECT_AR("selectAR"),
    INCOME_AND_SPENDING("income-and-spending"),
    CONTRACTS("contracts"),
    COUNTRY_SELECTION("country-selection");

    private final String pagePath;

    PageName(String pageName) {
        this.pagePath = pageName;
    }

}



