package web.form.service;


import lombok.extern.slf4j.Slf4j;
import web.form.model.PageName;
import web.form.model.incomeandspending.BaseIncomeAndSpending;


@Slf4j
public abstract class BaseIncomeAndSpendingService implements IncomeAndSpendingService {


    @Override
    public String supportedYear() {
        String year = this.getClass().getSimpleName().replaceAll("\\D", "");
        log.debug("Service supports year: {}", year);
        return year;
    }

    @Override
    public String getFormView() {
        String path = supportedYear() + "/income-and-spending";
        log.debug("Form view path: {}", path);
        return path;
    }

    @Override
    public String getNextPage(Object flow) {
        return "example";
    }

    @Override
    public void process(BaseIncomeAndSpending model) {
        PageName pageId = BaseIncomeAndSpending.getPAGE_ID();
        log.info("Processing model: {} for page: {}", model, pageId);

    }
}
