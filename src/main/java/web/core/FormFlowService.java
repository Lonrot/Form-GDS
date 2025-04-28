package web.core;


import org.springframework.stereotype.Service;
import web.form.model.Form;
import web.form.model.PageName;


@Service
public class FormFlowService {


    public String getNextStep (Form page){
         PageName currentStep = page.getPageID();
        return switch (currentStep) {
            case SELECT_AR -> "income-and-spending";
            case INCOME_AND_SPENDING -> "contracts";
            case CONTRACTS -> "country-selection";
            default -> "index";
        };
    }


}

